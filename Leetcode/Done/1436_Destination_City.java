// You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi. Return the destination city, that is, the city without any path outgoing to another city.
//
// It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.
//
//
//
// Example 1:
//
// Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
// Output: "Sao Paulo"
// Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city. Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".
// Example 2:
//
// Input: paths = [["B","C"],["D","B"],["C","A"]]
// Output: "A"
// Explanation: All possible trips are:
// "D" -> "B" -> "C" -> "A".
// "B" -> "C" -> "A".
// "C" -> "A".
// "A".
// Clearly the destination city is "A".
// Example 3:
//
// Input: paths = [["A","Z"]]
// Output: "Z"
//
//
// Constraints:
//
// 1 <= paths.length <= 100
// paths[i].length == 2
// 1 <= cityAi.length, cityBi.length <= 10
// cityAi != cityBi
// All strings consist of lowercase and uppercase English letters and the space character.






class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        String city = "";
        for(List<String> x : paths){
            map.put(x.get(0), x.get(1));
        }
        city = map.get(paths.get(0).get(0));
        while(map.containsKey(city)){
            city = map.get(city);
        }
        return city;
    }
}
// Time : O(N)
// Space : O(N)






class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> cities = new HashSet<>();
        for(List<String> x : paths){
            cities.add(x.get(1));
        }
        for(List<String> x : paths){
            cities.remove(x.get(0));
        }
        return cities.iterator().next();
    }
}
// Time : O(N)
// Space : O(N)
