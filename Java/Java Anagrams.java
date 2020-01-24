

    static boolean isAnagram(String a, String b) {
        // Complete the function

        if(a.length()!=b.length()) return false;

        if(a.length()==0) return true;

        String A = a.toUpperCase();
        String B = b.toUpperCase();

            char c = A.charAt(0);
            String s=Character.toString(c);
            
            A = A.replace(s,"");
            B = B.replace(s,"");

            return isAnagram(A,B);         
    }

