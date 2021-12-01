package com.jphalford.aoc.day2;

import com.jphalford.aoc.day2.input.CorporatePasswordPolicyConverter;
import com.jphalford.aoc.day2.input.CorporatePolicyAndPassword;
import com.jphalford.aoc.day2.policy.CorporatePolicyValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CompliantPasswordCounterTest {

    private static final String COMPLIANT = "COMPLIANT";
    private static final String NON_COMPLIANT = "NON COMPLIANT";

    @Mock
    CorporatePasswordPolicyConverter converter;

    @Mock
    CorporatePolicyValidator validator;

    @BeforeEach
    void setUp() {
        CorporatePolicyAndPassword compliantPaP = CorporatePolicyAndPassword.builder().password(COMPLIANT).build();
        CorporatePolicyAndPassword nonCompliantPaP = CorporatePolicyAndPassword.builder().password(NON_COMPLIANT).build();
        when(converter.convertPolicy(eq(COMPLIANT))).thenReturn(compliantPaP);
        when(converter.convertPolicy(eq(NON_COMPLIANT))).thenReturn(nonCompliantPaP);

        when(validator.isPasswordCompliant(eq(compliantPaP))).thenReturn(true);
        when(validator.isPasswordCompliant(eq(nonCompliantPaP))).thenReturn(false);
    }

    @Test
    void onlyCountValidOneValid() {
        CompliantPasswordCounter compliantPasswordCounter = new CompliantPasswordCounter(converter, validator);
        assertEquals(1, compliantPasswordCounter.numCompliantPasswords(asList(COMPLIANT, NON_COMPLIANT)));
    }

    @Test
    void onlyCountValidMultipleValid() {
        CompliantPasswordCounter compliantPasswordCounter = new CompliantPasswordCounter(converter, validator);
        assertEquals(2, compliantPasswordCounter.numCompliantPasswords(asList(COMPLIANT, NON_COMPLIANT, COMPLIANT)));
    }
}