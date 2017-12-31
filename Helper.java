package database;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Helper {
    
    private String SetU;
    private HashSet<String> Relations;
    
    // Getters & Setters (With simple Validation)
    public String getSetU(){
        return this.SetU;
    }
    public String setSetU(String s){
        boolean valid = false;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                valid = true;
                break;
            }
        } 
        if (!valid) s = "!";
        return this.SetU = s;
    }
    
    public HashSet<String> getRelations(){
        return this.Relations;
    }
    
    public HashSet<String> setRelations(HashSet<String> rel){
        boolean valid = true;
        for (String s:rel){
            if (s.length() == 0) {
                valid = false;
                break;
            }
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                if ( (c < 'A' || c > 'Z') && c != '-' && c != '>' ) {
                    valid = false;
                    break;
                }
            } 
            if (!valid) break;
        }
        if (!valid) rel.clear();
        return this.Relations = rel;
    }
    // End of Getters & Setters
    
    // jTextField input to SET (String)
    public String getSet(String text) {
        String ret = "";
        text = text.toUpperCase();
        for (int i=0;i<text.length();i++){
            char c = text.charAt(i);
            if (c >= 'A' && c <= 'Z'){
                ret += c;
            }
        }
        return ret;
    }
    
    // jTextArea input to SetOfFD's (List<String>)
    public HashSet<String> getRelations(String text) {
        HashSet<String> l = new HashSet<>();
        String s = "";
        text = text.toUpperCase();
        for (int i=0;i<text.length();i++){
            char c = text.charAt(i);
            if (c == '\n') {
                l.add(s);
                s = "";
            }
            if ((c >= 'A' && c <= 'Z')|| c=='-' || c=='>')
                s += c;
        }
        if ( !s.equals("") ) l.add(s);
        return l;
    }
    
    // return TRUE if same characters and same count of those characters
    public boolean strExact(String a,String b){
        int A[] = new int [27];
        int B[] = new int [27];
        for (int i=0;i<a.length();i++) A[a.charAt(i)-'A']++;
        for (int i=0;i<b.length();i++) B[b.charAt(i)-'A']++;
        for (int i=0;i<26;i++) if (A[i] != B[i]) return false;
        return true;
    }
    
    // given setX returns the closure to setX using Relations
    public String getClosure(String SetX){
        String ret = SetX;
        while (true){
            boolean change = false;
            for (int i=0;i<ret.length();i++){
                String pass = ""; pass += ret.charAt(i);
                String tmp = closureJoin(ret,closurePath(pass));
                if (!strExact(ret, tmp)) change = true;
                ret = tmp;
                for (int j=0;j<ret.length();j++){
                    if (i == j) continue;
                    pass = ""; pass += ret.charAt(i); pass += ret.charAt(j);
                    tmp = closureJoin(ret,closurePath(pass));
                    if (!strExact(ret, tmp)) change = true;
                    ret = tmp;
                }
            }
            if (!change) break;
        }
        return ret;
    }
    
    // Using relations find what can (lf) get
    private String closurePath(String lf){
        String ret = lf;
        for (String rel:Relations){
            String l = rel.substring(0,rel.indexOf('-'));
            String r = rel.substring(rel.indexOf('>')+1,rel.length());
            if (strExact(l,lf)) ret = closureJoin(ret,r);
        }
        return ret;
    }
    
    // Joining two strings as set of chars
    public String closureJoin(String a,String b){
        int A[] = new int [27];
        String ret = "";
        for (int i=0;i<a.length();i++) A[a.charAt(i)-'A']++;
        for (int i=0;i<b.length();i++) A[b.charAt(i)-'A']++;
        for (int i=0;i<26;i++) if (A[i] > 0) ret += (char)(i+'A');
        return ret;
    }
    
    // is r A Member of Close ??
    String getMembership(String close, String r) {
        int chars = 0;
        for (int i=0;i<r.length();i++){
            char c = r.charAt(i);
            if (close.indexOf(c) != -1) chars++;
        }
        if (chars == r.length()) return "TRUE";
        return "FALSE";
    }
    
    // finds the key to the set using relations set
    // the key of a set is a subset which closure covers the whole set
    String getKey() {
        String ret = this.SetU;
        String ans = "";
        for (int i=0;i<ret.length();i++){
            String rm = ret.substring(0,i) + ret.substring(i+1,ret.length());
            rm = getClosure(rm);
            if (rm.indexOf(ret.charAt(i)) == -1) ans += ret.charAt(i);
        }
        return ans;
    }
    
    // return the schema of the FD's
    public String getSchema(){
        HashMap<String,HashSet<String> > ret = new HashMap<>();
        for (String rel: Relations){
            System.out.println("Helper: " + rel);
            String l = rel.substring(0,rel.indexOf('-'));
            String r = rel.substring(rel.indexOf('>')+1,rel.length());
            String key = getClosure(l);
            if (ret.get(key) == null) ret.put(key,new HashSet<>());
            HashSet<String> tmp = ret.get(key);
            tmp.add(l+"->"+r);
            ret.put(key, null);
            ret.put(key, tmp);
        }
        String ans = "<html>";
        for (Map.Entry<String,HashSet<String>> entry: ret.entrySet()){
            String key = entry.getKey();
            HashSet<String> value = entry.getValue();
            ans += key + ":<br>";
            for (String rel:value){
                for (int i=0;i<10;i++) ans += "&nbsp;";
                ans += rel + "<br>";
            }
            ans += "<br>";
        }
        ans += "</html>";
        return ans;
    }
    
}
