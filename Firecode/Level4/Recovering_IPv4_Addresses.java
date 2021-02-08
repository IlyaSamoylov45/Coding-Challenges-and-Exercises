// You are given a String containing at least 4 numbers that represented an IPv4 Address, but the separator data - i.e. the dots that separate each Byte in a 4 Byte Ipv4 address, has been lost. Write a method - generateIPAddrs that takes in this String and returns an ArrayList of Strings containing all possible IPv4 Addresses that can be generated from the given sequence of decimal integers.
//
//
// Note:
//
// - The IP Addresses for this problem are written in the decimal dot notation.
//  - You must use all the digits in the input String
//  - The order in which the IP Addresses are returned does not matter
//  - 0.0.0.1 and 0.0.0.01 may be considered 2 distinct possibilities. i.e. do not ignore leading or trailing 0s.
//
// Examples:
//
// generateIPAddrs("1001") ==> {"1.0.0.1"}
//
// generateIPAddrs("1010") ==> {"1.0.1.0"}
//
// generateIPAddrs("25525511135") ==> {"255.255.11.135", "255.255.111.35"}



// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static ArrayList<String> generateIPAddrs(String s) {
    ArrayList<String> results = new ArrayList<>();
    String[] bytes = new String[4];
    int pos = 0;
    generateIPAddrs(s, 0, bytes, results, 0);
    return results;

}

public static void generateIPAddrs(String s, int start, String[] bytes, List<String> results, int pos){
    if(pos >= 4){
        if(start < s.length()){
            return;
        }
        String res = validate(bytes);
        if(res != null){
            results.add(res);
        }
        return;
    }

    for(int i = start; i < s.length() && i < start+3; i++){
        bytes[pos] = s.substring(start, i + 1);
        generateIPAddrs(s, i + 1, bytes, results, pos + 1);
    }
}

public static String validate(String[] bytes){
    String prefix = "";
    StringBuilder address = new StringBuilder();
    for(String x : bytes){
        if(x == null){
            return null;
        }
        if(x.charAt(0) == '0' && x.length() > 1){
            return null;
        }
        if(Integer.parseInt(x) > 255){
            return null;
        }
        address.append(prefix);
        address.append(x);
        prefix = ".";
    }
    return address.toString();
}
