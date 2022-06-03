package SETenMAP_opdracht1;


import java.util.*;

public class Date implements Comparable<Date>
{
    private int day;
    private int month;
    private int year;

    public Date( int day, int month, int year ) throws IllegalArgumentException {
        setDate(day, month, year);
    }

    private void setDate( int day, int month, int year ) throws IllegalArgumentException {
        if ( !isValidDate( day, month, year ) ) {
            throw new IllegalArgumentException("Invalid day-month-year combination.");
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void setYear( int year ) throws IllegalArgumentException {
        setDate( this.day, this.month, year );
    }

    public void setMonth( int month ) throws IllegalArgumentException {
        setDate( this.day, month, this.year );
    }

    public void setDay( int day ) throws IllegalArgumentException {
        setDate( day, this.month, this.year );
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public boolean isLeapYear( int year ) {
        boolean isLeapYear = false;
        if( year%4 == 0 ){
            if(! (year%100 == 0 && year%400 != 0)){
                isLeapYear = true;
            }
        }
        return isLeapYear;
    }

    public boolean isValidDate( int day, int month, int year ) {
        return month >= 1 &&
                month <= 12 &&
                day >= 1 &&
                day <= numberOfDaysInMonth( month, year );
    }

    public int numberOfDaysInMonth( int month, int year ) throws IllegalArgumentException {
        if(month < 1 || month > 12){
            throw new IllegalArgumentException("Invalid month.");
        }
        int nrOfDays = 31;
        switch ( month ) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                break;
            case 2:
                nrOfDays = isLeapYear( year ) ? 29 : 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                nrOfDays = 30;
                break;
        }
        return nrOfDays;
    }

    public boolean isBefore( Date otherDate ) {
        if ( otherDate == null ) {
            throw new IllegalArgumentException("Invalid date.");
        }
        boolean isBefore = false;
        if ( getYear() < otherDate.getYear() ) {
            isBefore = true;
        } else if ( getYear() == otherDate.getYear() ) {
            if ( getMonth() < otherDate.getMonth() ) {
                isBefore = true;
            } else if ( getMonth() == otherDate.getMonth() ) {
                isBefore = getDay() < otherDate.getDay();
            }
        }
        return isBefore;
    }

    public boolean isAfter( Date otherDate ) {
        if ( otherDate == null ) {
            throw new IllegalArgumentException("Invalid date.");
        }
        return otherDate.isBefore( this );
    }

    public void advanceSingleDay() {
        if ( getDay() == numberOfDaysInMonth( getMonth(), getYear() ) ) {
            if ( getMonth() == 12 ) {
                setDate( 1, 1, getYear() + 1 );
            } else {
                setDate( 1, getMonth() + 1, getYear() );
            }
        } else {
            setDate( getDay() + 1, getMonth() , getYear() );
        }
    }

    public void goBackSingleDay()  {
        if ( getDay() == 1 ) {
            if ( getMonth() == 1 ) {
                setDate( 31, 12, getYear() - 1 );
            } else {
                int nrOfDays =  numberOfDaysInMonth( getMonth() - 1, getYear() );
                setDate( nrOfDays , getMonth() - 1, getYear() );
            }
        } else {
            setDate( getDay() - 1 , getMonth(), getYear() );
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return day == date.day && month == date.month && year == date.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    // ordening van recent naar oud
    @Override
    public int compareTo(Date date) {
        if (this.isBefore(date)) return 1;
        if (this.isAfter(date)) return -1;
        return 0;
    }

    @Override
    public String toString(){
        String output = getDay()+"/"+getMonth()+"/"+getYear();
        return output;
    }

    public static void main(String[] args) {
        Date [] datums1 = {new Date(4,11,2020) ,new Date(14,10,2020), new Date(1,2,2019),
                new Date(12,12,2019), new Date(1,2,2019)};
        Date [] datums2 = {new Date(4,11,2020) ,new Date(16,10,2020), new Date(1,2,2019),
                new Date(12,12,2019), new Date(1,2,2019), new Date(1,12,2020),
                new Date(1,2,2019), new Date(16,10,2020)};

        List<Date> l1 = new ArrayList<>(Arrays.asList(datums1));
        List <Date> l2 = new ArrayList<>(Arrays.asList(datums2));
        System.out.println("rij1:"+"\n"+l1);
        System.out.println("rij2:"+"\n"+l2);

        System.out.println("gemeenschappelijke letters in rij letters1 en letters2, dubbels niet toegelaten");
        // TO DO Tip maak gebruik van Set en de retainAll methode
        Set<Date> s1 = new HashSet<Date>(l1);
        Set<Date> s2 = new HashSet<Date>(l2);
        s1.retainAll(s2);
        System.out.println(s1);

        System.out.println("gemeenschappelijke letters in rij letters1 en letters2, dubbels niet toegelaten, alfabetisch geordend");
        // TO DO Tip idem als vorige opdracht maar gebruik juist type van Set
        Set<Date> s3 = new TreeSet<>(l1);
        Set<Date> s4 = new TreeSet<>(l2);
        s3.retainAll(s4);
        System.out.println(s3);

        System.out.println("Aantal voorkomens van elke letter in rij letters2,alfabetisch geordend");
        // TO DO Tip gebruik map waarbij een letter een key is en een teller de value
        Map <Date,Integer> map = new TreeMap<>();
        for (Date s: datums2) {
            int aantal = 1;
            if(map.containsKey(s)) {
                aantal = map.get(s) + 1;
            }
            map.put(s,aantal);
        }

        // De volgende code overloopt de set van entries uit de treemap,
        // haalt uit de entry de key en de value en print deze geformateerd f
        Set <Map.Entry<Date, Integer>> set = map.entrySet();
        for (Map.Entry<Date,Integer> entry:set){
            String output = String.format("%2s: %2d", entry.getKey(),entry.getValue());
            System.out.println(output);
        }

        System.out.println("Alfabetische opsomming van letters in rij letters2 die 1, 2, 3 en 4 keer voorkomen");
        Map <Integer,Set<Date>> map2 = new TreeMap<>();
        for (int i =1; i < 5;i++){
            map2.put(i,new TreeSet<>() );
        }
        // TO DO Tip hierboven hebben we een multimap gemaakt met als key een getal van 1 tot 4
        // en als value een treeset van letters die 1, 2, 3 of 4 keren voorkomen
        // de 4 entries van map2 zijn al aangemaakt maar de values zijn nog leeg
        for (Map.Entry<Date,Integer> entry:set){
            // wij overlopen de set van entries van de map uit de vorige opdracht
            int aantal = entry.getValue();
            if(map2.containsKey(aantal)) {
                map2.get(aantal).add(entry.getKey());
            }
            // TO DO pas de inhoud van map2 aan
        }
        // hier wordt de inhoud van map2 getonnd op de console
        Set <Map.Entry<Integer,Set<Date>>> set2 = map2.entrySet();
        for (Map.Entry<Integer,Set<Date>> entry:set2){
            String output = String.format("%2s: %-20s", entry.getKey(),entry.getValue());
            System.out.println(output);
        }
    }
    }



