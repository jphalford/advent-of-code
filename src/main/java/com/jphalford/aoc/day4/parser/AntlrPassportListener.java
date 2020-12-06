package com.jphalford.aoc.day4.parser;

import com.jphalford.aoc.day4.PassportBaseListener;
import com.jphalford.aoc.day4.PassportData;
import com.jphalford.aoc.day4.PassportParser;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class AntlrPassportListener extends PassportBaseListener {

    private List<PassportData> passportDataList;
    private PassportData.PassportDataBuilder passportDataBuilder;
    private Function<String, PassportData.PassportDataBuilder> passportDataValueSetter;

    public List<PassportData> getPassportDataList() {
        return passportDataList;
    }

    @Override
    public void enterBatchFile(PassportParser.BatchFileContext ctx) {
        passportDataList = new ArrayList<>();
    }

    @Override
    public void enterPassport(PassportParser.PassportContext ctx) {
        passportDataBuilder = PassportData.builder();
    }

    @Override
    public void exitPassport(PassportParser.PassportContext ctx) {
        passportDataList.add(passportDataBuilder.build());
    }

    @Override
    public void enterBirthYear(PassportParser.BirthYearContext ctx) {
        passportDataValueSetter = passportDataBuilder::birthYear;
    }

    @Override
    public void enterIssueYear(PassportParser.IssueYearContext ctx) {
        passportDataValueSetter = passportDataBuilder::issueYear;
    }

    @Override
    public void enterExpirationYear(PassportParser.ExpirationYearContext ctx) {
        passportDataValueSetter = passportDataBuilder::expirationYear;
    }

    @Override
    public void enterHeight(PassportParser.HeightContext ctx) {
        passportDataValueSetter = passportDataBuilder::height;
    }

    @Override
    public void enterHairColor(PassportParser.HairColorContext ctx) {
        passportDataValueSetter = passportDataBuilder::hairColor;
    }

    @Override
    public void enterEyeColor(PassportParser.EyeColorContext ctx) {
        passportDataValueSetter = passportDataBuilder::eyeColor;
    }

    @Override
    public void enterPassportId(PassportParser.PassportIdContext ctx) {
        passportDataValueSetter = passportDataBuilder::passportId;
    }

    @Override
    public void enterCountryId(PassportParser.CountryIdContext ctx) {
        passportDataValueSetter = passportDataBuilder::countryId;
    }

    @Override
    public void enterValue(PassportParser.ValueContext ctx) {
        passportDataValueSetter.apply(ctx.getStart().getText());
    }
}
