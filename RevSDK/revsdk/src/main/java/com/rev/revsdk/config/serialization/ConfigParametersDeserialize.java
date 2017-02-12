package com.rev.revsdk.config.serialization;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.rev.revsdk.config.ConfigParamenetrs;
import com.rev.revsdk.config.ListString;
import com.rev.revsdk.config.OperationMode;

import java.lang.reflect.Type;

/**
 * Created by victor on 03.02.17.
 */

public class ConfigParametersDeserialize implements JsonDeserializer<ConfigParamenetrs> {
    @Override
    public ConfigParamenetrs deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        ConfigParamenetrs config = new ConfigParamenetrs();
        if(json == null) return config;

        OperationModeDeserialize opDeser = new OperationModeDeserialize();
        ListStringDeserializer lsDeser = new ListStringDeserializer();
        JsonObject obj = json.getAsJsonObject();
        if(obj == null) return config;


        config.setSdk_release_version(obj.get("sdk_release_version").getAsString());
        config.setLogging_level(obj.get("logging_level").getAsString());
        config.setConfiguration_api_url(obj.get("configuration_api_url").getAsString());
        config.setConfiguration_refresh_interval_sec(obj.get("configuration_refresh_interval_sec").getAsInt());
        config.setConfiguration_request_timeout_sec(obj.get("configuration_request_timeout_sec").getAsInt());
        config.setConfiguration_stale_timeout_sec(obj.get("configuration_stale_timeout_sec").getAsInt());
        config.setEdge_host(obj.get("edge_host").getAsString());
        config.setOperation_mode(opDeser.deserialize(obj.get("operation_mode"), OperationMode.class, context));
        config.setAllowed_transport_protocols(lsDeser.deserialize(obj.get("allowed_transport_protocols").getAsJsonArray(), ListString.class, context));
        config.setInitial_transport_protocol(obj.get("initial_transport_protocol").getAsString());
        config.setTransport_monitoring_url(obj.get("transport_monitoring_url").getAsString());
        config.setStats_reporting_url(obj.get("stats_reporting_url").getAsString());
        config.setStats_reporting_interval_sec(obj.get("stats_reporting_interval_sec").getAsInt());
        config.setStats_reporting_level(obj.get("stats_reporting_level").getAsString());
        config.setStats_reporting_max_requests_per_report(obj.get("stats_reporting_max_requests_per_report").getAsInt());
        config.setDomains_provisioned_list(lsDeser.deserialize(obj.get("domains_provisioned_list").getAsJsonArray(), ListString.class, context));
        config.setDomains_white_list(lsDeser.deserialize(obj.get("domains_white_list").getAsJsonArray(), ListString.class, context));
        config.setDomains_black_list(lsDeser.deserialize(obj.get("domains_black_list").getAsJsonArray(), ListString.class, context));
        config.setInternal_domains_black_list(lsDeser.deserialize(obj.get("internal_domains_black_list").getAsJsonArray(), ListString.class, context));
        config.setA_b_testing_origin_offload_ratio(obj.get("a_b_testing_origin_offload_ratio").getAsInt());
        config.setEdge_connect_timeout_sec(obj.get("edge_connect_timeout_sec").getAsInt());
        config.setEdge_data_receive_timeout_sec(obj.get("edge_data_receive_timeout_sec").getAsInt());
        config.setEdge_first_byte_timeout_sec(obj.get("edge_first_byte_timeout_sec").getAsInt());
        config.setEdge_sdk_domain(obj.get("edge_sdk_domain").getAsString());
        config.setEdge_quic_udp_port(obj.get("edge_quic_udp_port").getAsInt());
        config.setEdge_failures_monitoring_interval_sec(obj.get("edge_failures_monitoring_interval_sec").getAsInt());
        config.setEdge_failures_failover_threshold_percent(obj.get("edge_failures_failover_threshold_percent").getAsInt());
        return config;
    }
}
