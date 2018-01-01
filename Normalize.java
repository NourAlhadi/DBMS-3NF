package database;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Normalize {
    private String SetU;
    private HashSet<String> Relations;
    
    // Start of Getters && Setters
    public String getSetU(){
        return this.SetU;
    }
    public String setSetU(String s){
        return this.SetU = s;
    }
    
    public HashSet<String> getRelations(){
        return this.Relations;
    }
    public HashSet<String> setRelations(HashSet<String> rel){
        return this.Relations = rel;
    }
    // End of Getters and Setters
    
    // Exclude A Relation from relations set
    public HashSet<String> excRelation(HashSet<String>rel,String tar){
        HashSet<String> ret = new HashSet<>();
        int id = 0;
        for (String s:rel){
            if (!s.equals(tar)) ret.add(s);
            id++;
        }
        return ret;
    }
    
    // First Char of String
    public char firstChar(String s){
        char ret = '#';
        for (int i=0;i<s.length();i++){
            char x = s.charAt(i);
            if (x > 'Z' || x < 'A') continue;
            ret = x;
        }
        return ret;
    }
    
    // Right Minimal Easy Just make a->bc to be a->b && a->c
    public HashSet<String> getRightMinimal(){
        HashSet<String> ret = new HashSet<>();
        for (String s:Relations){
            HashSet<String> tmp = getRightFix(s);
            for (String t:tmp){
                ret.add(t);
            }
        }
        return ret;
    }
    
    private HashSet<String> getRightFix(String s) {
        HashSet<String> ret = new HashSet<>();
        
        String l = s.substring(0,s.indexOf('-'));
        String r = s.substring(s.indexOf('>')+1,s.length());
        
        for (int i=0;i<r.length();i++){
            char c = r.charAt(i);
            if (c > 'Z' || c < 'A') continue;
            ret.add(l+"->"+c);
        }
        return ret;
    }
    
    // Left Reduction ab-> c if a can get to b just remove b
    public HashSet<String> getLeftReduction(){
        HashSet<String> Start = getRightMinimal();
        HashSet<String> ret = new HashSet<>();
        for (String rel:Start){
            String l = rel.substring(0,rel.indexOf('-'));
            String r = rel.substring(rel.indexOf('>')+1,rel.length());
            ret.add(getLeftFix(l,r,Start,rel));
        }
        return ret;
    }

    private String getLeftFix(String l, String r,HashSet<String> rel, String tar) {
        String ret = l + "->" + r;
        Helper h = new Helper();
        HashSet<String> nRel = excRelation(rel,tar);
        h.setSetU(this.SetU);
        h.setRelations(nRel);
        char a = '#',b = '#';
        for (int i=0;i<l.length();i++){
            char c = l.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            if (a == '#') a = c;
            else b = c;
        }
        if (b == '#') return l + "->" + r;
        String aClose = h.getClosure(""+a);
        String bClose = h.getClosure(""+b);
        if (aClose.indexOf(b) != -1) return a + "->" + r;
        if (bClose.indexOf(a) != -1) return b + "->" + r;
        return ret;
    }
    
    // Non redundant:for each relation remove temporarly and get closure l if you can get r commit remove
    public HashSet<String> getNonRedundant(){
        HashSet<String> ret = getLeftReduction();
        while (true){
            int cnt = ret.size();
            for (String rel : ret){
                ret = checkRemove(rel,rel,ret);
            }
            if (ret.size() == cnt) break;
        }
        return ret;
    }
    
    public HashSet<String> checkRemove(String rel,String tar,HashSet<String> curr){
        HashSet<String> ret = excRelation(curr, tar);
        Helper h = new Helper();
        h.setSetU(this.SetU);
        h.setRelations(ret);
        String l = rel.substring(0,rel.indexOf('-'));
        String r = rel.substring(rel.indexOf('>')+1,rel.length());
        String close = h.getClosure(l);
        boolean ch = checkCover(close,r);
        if (ch) return ret;
        return curr;
    }
    
    public boolean checkCover(String a,String b){
        int diff[] = new int [27];
        int ret = 0;
        
        for (int i=0;i<b.length();i++) {
            char c = b.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            diff[c-'A']++;
        }
        
        for (int i=0;i<a.length();i++) {
            char c = a.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            if (diff[c-'A'] != 0) diff[c-'A']--;
        }
        
        for (int i=0;i<27;i++) ret += diff[i];
        return ret == 0;
    }
    
    // return the schema of the FD's
    public String getSchema(){
        HashMap<String,HashSet<String> > ret = new HashMap<>();
        Helper h = new Helper();
        h.setSetU(SetU);
        HashSet<String> rels = h.setRelations(getNonRedundant());
        for (String rel: rels){
            String l = rel.substring(0,rel.indexOf('-'));
            String r = rel.substring(rel.indexOf('>')+1,rel.length());
            String key = h.getClosure(l);
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
