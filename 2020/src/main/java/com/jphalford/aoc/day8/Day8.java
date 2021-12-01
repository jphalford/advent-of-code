package com.jphalford.aoc.day8;

import java.util.ArrayList;
import java.util.List;

public class Day8 {
    public static final int OPERATION_START_INDEX = 0;
    public static final int OPERATION_END_INDEX = 3;
    public static final int ARGUMENT_START_INDEX = OPERATION_END_INDEX + 1;
    public static final String NOP_OPERATION = "nop";
    public static final String JMP_OPERATION = "jmp";

    public long solvePart1(List<String> instructions) {
        InstructionExecutor loopStart = executeUntilEndOrLoopStart(instructions);
        long loopPtr = loopStart.ptr;

        do {
            loopStart.executeInstruction();
        } while (loopStart.ptr != loopPtr);

        return loopStart.acc;
    }

    public long solvePart2(List<String> instructions) {
        for (int i = 0; i < instructions.size(); i++) {
            String instruction = instructions.get(i);
            String modifiedInstruction = swapNopAndJmp(instruction, InstructionExecutor.getOperation(instruction));

            if (instruction.equals(modifiedInstruction)) {
                continue;
            }

            List<String> modifiedInstructions = new ArrayList<>(instructions);
            modifiedInstructions.set(i, modifiedInstruction);

            InstructionExecutor instructionExecutor = executeUntilEndOrLoopStart(modifiedInstructions);
            if (instructionExecutor.isComplete()) {
                return instructionExecutor.acc;
            }
        }

        throw new IllegalArgumentException("No completed instructions");
    }

    private InstructionExecutor executeUntilEndOrLoopStart(List<String> instructions) {
        InstructionExecutor hare = new InstructionExecutor(instructions);
        InstructionExecutor tortoise = new InstructionExecutor(instructions);

        do {
            tortoise.executeInstruction();
            hare.executeInstruction();
            hare.executeInstruction();
        } while (tortoise.ptr != hare.ptr);

        if (hare.isComplete()) {
            return hare;
        }

        tortoise.reset();
        while (tortoise.ptr != hare.ptr) {
            tortoise.executeInstruction();
            hare.executeInstruction();
        }
        return tortoise;
    }

    private String swapNopAndJmp(String instruction, String operation) {
        String modifiedInstruction = instruction;

        switch (operation) {
            case NOP_OPERATION:
                modifiedInstruction = instruction.replace(NOP_OPERATION, JMP_OPERATION);
                break;
            case JMP_OPERATION:
                modifiedInstruction = instruction.replace(JMP_OPERATION, NOP_OPERATION);
                break;
        }

        return modifiedInstruction;
    }

    private static class InstructionExecutor {
        private final List<String> instructions;
        private long acc;
        private int ptr;

        private InstructionExecutor(List<String> instructions) {
            this.instructions = instructions;
        }

        boolean isComplete() {
            return ptr >= instructions.size();
        }

        void reset() {
            acc = 0;
            ptr = 0;
        }

        void executeInstruction() {
            if (isComplete()) {
                return;
            }

            String instruction = instructions.get(ptr);
            String operation = getOperation(instruction);
            int argument = Integer.parseInt(instruction.substring(ARGUMENT_START_INDEX));

            switch (operation) {
                case NOP_OPERATION:
                    ptr++;
                    break;
                case "acc":
                    ptr++;
                    acc += argument;
                    break;
                case JMP_OPERATION:
                    ptr += argument;
                    break;
                default:
                    throw new IllegalArgumentException("Unkown Operation: " + operation);
            }
        }

        static String getOperation(String instruction) {
            return instruction.substring(OPERATION_START_INDEX, OPERATION_END_INDEX);
        }
    }
}
