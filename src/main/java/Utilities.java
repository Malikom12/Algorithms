package main.java;

public class Utilities {
    /**
     * Used to return the position of a string
     * @param textArr the array being searched through
     * @param value the string being searched for
     * @return -1 if string is not in array
     */
    public static int locateString(String[] textArr, String value){
        if (textArr != null && !value.isEmpty()){
            for (int i = 0; i < textArr.length; i++){
                if (textArr[i].equalsIgnoreCase(value)){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * merging two arrays
     * @param text1 first array
     * @param text2 second array were taking values from
     * @param count1 num of elements from first array were taking
     * @param count2 number of values were taking from second array
     * @return the merged array
     */
    public static String[] merge(String[] text1, String[] text2, int count1, int count2){
        String[] arr2 = new String[0];
        if (text1 != null && text2 != null){
            if (count1 > text1.length || count1 < 0){
                return arr2;
            }
            if (count2 > text2.length || count2 < 0){
                return arr2;
            }

            arr2 = new String[count1 + count2];

            for (int i = 0; i < count1; i++){
                arr2[i] = text1[i];
            }
            for (int i = 0; i < count2; i++){
                arr2[count1 + i] = text2[i];
            }

        }
        return arr2;
    }


    /**
     * Growing an array, used to make the array longer
     * @param arr1 the array we are growing
     * @return the grown array
     */
    public static String[] grow(String[] arr1){
        String[] arr2 = new String[arr1.length+1];
        for (int i = 0; i < arr1.length; i++){
            arr2[i] = arr1[i];
        }
        return arr2;
    }


    /**
     * a method to check if a array contains a value
     * @param data array being checked
     * @param element value we are checking for in array
     * @param cutoff how many values were checking
     * @return true if it does contain or false else wise
     */
    public static boolean contains(String [] data, String element, int cutoff){
        for(int i = 0; i < cutoff; i++){
            if(data[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    /**
     * Deduplicating an array, getting rid of duplicate values it may have
     * @param textArr array being provided
     * @param startPos from where in array onwards we are deduplicating
     * @return deduplicated array
     */
    public static String[] deduplicate_ArrayGrowth(String [] textArr, int startPos){
        if(textArr == null){
            return new String[0];
        }
        if (startPos >= 0 && startPos < textArr.length){
            return new String[0];
        }

        String [] filtered = new String[0];
        int tracker = 0;

        for(int i = 0; i < textArr.length; i++){
            if(!contains(filtered, textArr[i], tracker)){
                filtered = grow(filtered);
                filtered[tracker] = textArr[i];
                tracker++;
            }
        }

        filtered = merge(textArr, filtered, textArr.length - startPos, filtered.length);
        return filtered;
    }



}
