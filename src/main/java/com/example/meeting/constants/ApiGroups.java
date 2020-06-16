package com.example.meeting.constants;

public final class ApiGroups {

    private ApiGroups() {
    }

    public static final class ProvinceOperationApi {
        public static final String NAME = "provinceoperation-api";
        public static final String TITLE = "ProvinceOperationApi";
        public static final String PATH = "/api/province/**";
        public static final String DESCRIPTION = "Province Operation Api";

        private ProvinceOperationApi() {
        }
    }

    public static final class DistrictOperationApi {
        public static final String NAME = "districtoperation-api";
        public static final String TITLE = "DistrictOperationApi";
        public static final String PATH = "/api/district/**";
        public static final String DESCRIPTION = "District Operation Api";

        private DistrictOperationApi() {
        }
    }

    public static final class CompanyOperationApi {
        public static final String NAME = "companyoperation-api";
        public static final String TITLE = "CompanyOperationApi";
        public static final String PATH = "/api/company/**";
        public static final String DESCRIPTION = "Company Operation Api";

        private CompanyOperationApi() {
        }
    }

    public static final class RegisterOperationApi {
        public static final String NAME = "registeroperation-api";
        public static final String TITLE = "RegisterOperationApi";
        public static final String PATH = "/api/register/**";
        public static final String DESCRIPTION = "Register Operation Api";

        private RegisterOperationApi() {
        }
    }

    public static final class MeetingRoomOperationApi {
        public static final String NAME = "meetingroomoperation-api";
        public static final String TITLE = "MeetingRoomOperationApi";
        public static final String PATH = "/api/meeting-room/**";
        public static final String DESCRIPTION = "Meeting Room Operation Api";

        private MeetingRoomOperationApi() {
        }
    }

    public static final class ReservationOperationApi {
        public static final String NAME = "reservationoperation-api";
        public static final String TITLE = "ReservationOperationApi";
        public static final String PATH = "/api/reservation/**";
        public static final String DESCRIPTION = "Reservation Operation Api";

        private ReservationOperationApi() {
        }
    }
}