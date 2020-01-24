
        HashMap<String,Set<String>> values = new HashMap<>();
        int count = 0;
        for(int i=0;i<t;i++) {
            if(values.containsKey(pair_left[i])) {
                if(!values.get(pair_left[i]).contains(pair_right[i])) {
                     ++count;  
                     System.out.println(count); 
                     Set names = values.get(pair_left[i]);
                     names.add(pair_right[i]);
                     values.put(pair_left[i], names);
                } else {
                    System.out.println(count); 
                }
            } else {
                ++count;
                System.out.println(count);
                Set<String> names = new HashSet();
                names.add(pair_right[i]);
                values.put(pair_left[i], names);
            }
        }   

