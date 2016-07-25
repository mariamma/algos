package com.manto9.column3;

/**
 * Created by manto9 on 01/04/16.
 */
public class Calendar {
    public enum Day{
        Sunday, Monday, Tuesday, Wednesday, Thursday,
        Friday, Saturday
    }
    public enum Month{
        Jan(31), Feb(28), Mar(31),
        Apr(30), May(31), June(30),
        Jul(31), Aug(31), Sep(30),
        Oct(31), Nov(30), Dec(31);

        private final int days;

        Month(int days) {
            this.days = days;
        }

        private int getDays(){
            return days;
        }

        public int getDaysBetweenMonths(int m1,int m2){
            int total = 0;
            m1--;
            m2--;
            System.out.println("Days between " + Month.values()[m1] + " and " + Month.values()[m2] );
            if(m1==m2)
                return Month.values()[m1].getDays();
            else if(m1<m2){
                for(int i=m1;i<=m2;i++){
                    total+=Month.values()[i].getDays();
                }
            }else{
                for(int i=m1;i<Month.values().length;i++){
                    total+=Month.values()[i].getDays();
                }
                for(int i=0;i<=m2;i++){
                    total+=Month.values()[i].getDays();
                }
            }
            return total;
        }

        public int countLeapDays(int y1, int y2){
            int l1 = y1/4 - y1/100 + y1/400;
            int l2 = y2/4 - y2/100 + y2/400;
            return l2-l1;
        }

        public int getDaysBetweenDate(Date d1, Date d2){
            int yrs,total,leap_cnt,days;
            yrs = total = leap_cnt = days = 0;
            yrs = d2.getYear() - d1.getYear();
            if((d2.getMon()<d1.getMon())||((d2.getMon()==d1.getMon())&&(d2.getDate()<d1.getDate()))){
                yrs--;
            }
            total += yrs*365;
            System.out.println("Yrs: " + yrs + " Total days: " + total);
            if(!((d1.getMon()==d2.getMon())&&(d1.getDate()<=d2.getDate()))) {
                days = getDaysBetweenMonths(d1.getMon()+1, d2.getMon()-1);
            }
            total += days;
            System.out.println("Mon days: " + days + " Total days: " + total);
            total += d2.getDate() + Month.values()[d1.getMon()-1].getDays() - d1.getDate();
            System.out.println("Total days: " + total);
            leap_cnt = countLeapDays(d1.getYear(),d2.getYear());
            total += leap_cnt;
            System.out.println("Total days: " + total);
            return total;

        }

        public int dayOfDate(int days, int s_date){
            int day = days%7;
            return (day + s_date)%7;
        }

        public static void main(String[] args) {
            Calendar cal = new Calendar();
            int days;
            Date d1 = new Date(4,4,2016);
            Date d2 = new Date(1,8,2016);
            System.out.println(Month.Jan.getDaysBetweenMonths(5,5));
            System.out.println(Month.Jan.getDaysBetweenMonths(1,3));
            days = Month.Jan.getDaysBetweenDate(d1,d2);
            int st_day = Month.Jan.dayOfDate(days,1);
            System.out.println("Day is: " + Day.values()[st_day]);
            int day_cnt=0;
            for(int i=1;i<=st_day;i++){
                System.out.print("  ");
                day_cnt++;
            }
            for(int i=1;i<=Month.values()[d2.getMon()-1].getDays();i++){
                System.out.print(i +" ");
                day_cnt++;
                if(day_cnt%7==0) System.out.print("\n");
            }
        }
    }
}
