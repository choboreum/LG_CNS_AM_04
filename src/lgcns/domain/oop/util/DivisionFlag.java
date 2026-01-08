package lgcns.domain.oop.util;

public enum DivisionFlag {
    STU("학생"), TEA("강사");

    private final String division;
    private DivisionFlag(String division){
        this.division = division;
    }

    public String getDivision(){
        return this.division;
    }
}
