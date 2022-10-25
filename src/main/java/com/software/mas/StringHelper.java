package com.software.mas;

import java.util.Set;
import java.util.stream.Collectors;

public class StringHelper {
    public static String capitalize(String str)
    {
        if (str == null || str.length() == 0) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static Set<String> capitalizeSet(Set<String> set){

        return set.stream().map(StringHelper::capitalize).collect(Collectors.toSet());
    }

}
