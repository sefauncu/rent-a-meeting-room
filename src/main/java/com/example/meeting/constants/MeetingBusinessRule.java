package com.example.meeting.constants;

public enum MeetingBusinessRule {

    PROVINCE_NOT_FOUND("PROVINCE_NOT_FOUND"),
    COMPANY_NOT_FOUND("COMPANY_NOT_FOUND"),
    DISTRICT_NOT_FOUND("DISTRICT_NOT_FOUND"),
    MEETING_ROOM_NOT_FOUND("MEETING_ROOM_NOT_FOUND"),

    PROVINCE_NAME_NOT_FOUND("PROVINCE_NAME_NOT_FOUND"),
    COMPANY_NAME_NOT_FOUND("COMPANY_NAME_NOT_FOUND"),
    DISTRICT_NAME_NOT_FOUND("DISTRICT_NAME_NOT_FOUND"),
    MEETING_ROOM_NAME_NOT_FOUND("MEETING_ROOM_NAME_NOT_FOUND"),

    REGISTER_TITLE_NOT_FOUND("REGISTER_TITLE_NOT_FOUND"),
    RESERVATION_CODE_NOT_FOUND("RESERVATION_CODE_NOT_FOUND"),

    START_DATE_NOT_FOUND("START_DATE_NOT_FOUND"),
    END_DATE_NOT_FOUND("END_DATE_NOT_FOUND"),
    DATE_RANGE_IS_INVALID("DATE_RANGE_IS_INVALID"),

    PROVINCE_DOES_NOT_MATCH("PROVINCE_DOES_NOT_MATCH"),

    THE_MEETING_ROOM_HAS_BEEN_RESERVED_SUCCESSFULLY("THE_MEETING_ROOM_HAS_BEEN_RESERVED_SUCCESSFULLY"),
    THIS_MEETING_ROOMS_CAPACITY_RESTRICTED("THIS_MEETING_ROOMS_CAPACITY_RESTRICTED"),
    MEETING_ROOM_HAS_BEEN_RESERVED_PLEASE_TRY_FOR_OTHER_TIMES("MEETING_ROOM_HAS_BEEN_RESERVED_PLEASE_TRY_FOR_OTHER_TIMES"),

    PEOPLE("PEOPLE");
    
    MeetingBusinessRule(String description) {
        this.description = description;
    }

    private String description;

    public String getDescription() {
        return this.description;
    }

}