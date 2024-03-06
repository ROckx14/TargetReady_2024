public class CalenderPrinter {

    public static void printCalender(int month, int year) {
        if(isValidDate(month,year)) {
            printHeader();
            printMonthCalender(month, year);
        }
    }

    public static boolean isValidDate(int month,int year) {
        return !(month<1 || month>12 || year<0);
    }

    public static void printHeader() {
        System.out.println("Su Mo Tu We Th Fr Sa");
    }

    public static void printMonthCalender(int month, int year) {
        int startDay = getStartDay(month, year);
        int noOfDays = getNoOfDaysInMonth(month, year);

        for(int i=0;i<startDay;i++) {
            System.out.printf("   ");
        }

        for(int day=1;day<=noOfDays;day++) {
            System.out.printf("%2d ",day);

            if((day+startDay)%7 == 0) {
                System.out.println();
            }
        }
    }

    public static int getNoOfDaysInMonth(int month, int year) {
        int noOfDays = 31;

        switch (month) {
            case 2:
                noOfDays = isLeapYear(year) ? 29 : 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                noOfDays = 30;
        }
        return noOfDays;
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getStartDay(int month, int year) {
        if (month < 3) {
            month += 12;
            year--;
        }
        int k = year % 100;
        int j = year / 100;
        int day = 1;

        return (day + (13 * (month + 1)) / 5 + k + (k / 4) + (j / 4) - (2 * j) + 6) % 7;
    }

    public static void main(String[] args) {
        printCalender(6,2019);
    }

}
