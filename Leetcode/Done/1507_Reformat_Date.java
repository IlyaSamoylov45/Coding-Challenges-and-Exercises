// Given a date string in the form Day Month Year, where:
//
// Day is in the set {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}.
// Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}.
// Year is in the range [1900, 2100].
// Convert the date string to the format YYYY-MM-DD, where:
//
// YYYY denotes the 4 digit year.
// MM denotes the 2 digit month.
// DD denotes the 2 digit day.
//
//
// Example 1:
//
// Input: date = "20th Oct 2052"
// Output: "2052-10-20"
// Example 2:
//
// Input: date = "6th Jun 1933"
// Output: "1933-06-06"
// Example 3:
//
// Input: date = "26th May 1960"
// Output: "1960-05-26"
//
//
// Constraints:
//
// The given dates are guaranteed to be valid, so no error handling is necessary.





class Solution {

    public String reformatDate(String date) {
        Map<String, String> months =  getMonths();
        String[] vals = date.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(vals[2]).append("-")
            .append(months.get(vals[1])).append("-")
            .append(vals[0].length() == 3 ? ("0" + vals[0].substring(0, 1)) : vals[0].substring(0, 2));
        return sb.toString();
    }

     private static Map<String, String> getMonths(){
        Map<String, String> months = new HashMap<>();
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");
        return months;
    }
}
// Time : O(N)
// Space : O(N)







class Solution {
    public String reformatDate(String date) {
        Map<String, String> months =  setMonths();
        String[] vals = date.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(vals[2])
            .append("-")
            .append(months.get(vals[1]))
            .append("-")
            .append(getDay(vals[0]));
        return sb.toString();
    }

     private static Map<String, String> setMonths(){
        Map<String, String> months = new HashMap<>();
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");
        return months;
    }

    private static String getDay(String day){
        return day.length() == 3 ? ("0" + day.substring(0, 1)) : day.substring(0, 2);
    }
}
// Time : O(N)
// Space : O(N)
