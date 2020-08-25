package com.learn;

import java.util.UUID;

public class StringReplace {
    public static void main(String[] args) {
        String input = "copy into @crds_json_stage_2/{folder}/file from (select a.json_data:customer_id as dcsid, a.json_data:core_customer_profile_id as ccpid ,a.json_data:last_update_crds_source_system as source from profile_json a, lateral flatten(input => a.json_data:favorite_restaurants) b where b.value:favorite_restaurant_code='80785') header=true";
        String replaced = input.replace("{folder}", UUID.randomUUID().toString());
        System.out.println(replaced);
    }
}
