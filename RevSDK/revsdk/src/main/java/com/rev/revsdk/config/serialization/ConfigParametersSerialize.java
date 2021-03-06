package com.rev.revsdk.config.serialization;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.rev.revsdk.config.ConfigParamenetrs;
import com.rev.revsdk.config.ListString;
import com.rev.revsdk.config.OperationMode;

import java.lang.reflect.Type;

/**
 * Created by victor on 03.02.17.
 */

public class ConfigParametersSerialize implements JsonSerializer<ConfigParamenetrs> {
    @Override
    public JsonElement serialize(ConfigParamenetrs src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        OperationModeSerialize serMode = new OperationModeSerialize();
        ListStrintgSerialize serArr = new ListStrintgSerialize();

        result.addProperty("sdk_release_version", src.getSdk_release_version());
        result.addProperty("logging_level", src.getLogging_level());
        result.addProperty("configuration_api_url", src.getConfiguration_api_url());
        result.addProperty("configuration_refresh_interval_sec", src.getConfiguration_refresh_interval_sec());
        result.addProperty("configuration_request_timeout_sec", src.getConfiguration_request_timeout_sec());
        result.addProperty("configuration_stale_timeout_sec", src.getConfiguration_stale_timeout_sec());
        result.addProperty("edge_host", src.getEdge_host());
        result.add("operation_mode", serMode.serialize(src.getOperation_mode(),OperationMode.class, context));
        result.add("allowed_transport_protocols", serArr.serialize(src.getAllowed_transport_protocols(), ListString.class, context));
        result.addProperty("initial_transport_protocol", src.getInitial_transport_protocol());
        result.addProperty("transport_monitoring_url", src.getTransport_monitoring_url());
        result.addProperty("stats_reporting_url", src.getStats_reporting_url());
        result.addProperty("stats_reporting_interval_sec", src.getStats_reporting_interval_sec());
        result.addProperty("stats_reporting_level", src.getStats_reporting_level());
        result.addProperty("stats_reporting_max_requests_per_report", src.getStats_reporting_max_requests_per_report());
        result.add("domains_provisioned_list", serArr.serialize(src.getDomains_provisioned_list(), ListString.class, context));
        result.add("domains_white_list", serArr.serialize(src.getDomains_white_list(), ListString.class, context));
        result.add("domains_black_list", serArr.serialize(src.getDomains_black_list(), ListString.class, context));
        result.add("internal_domains_black_list", serArr.serialize(src.getInternal_domains_black_list(), ListString.class, context));
        result.addProperty("a_b_testing_origin_offload_ratio", src.getA_b_testing_origin_offload_ratio());
        result.addProperty("edge_connect_timeout_sec", src.getEdge_connect_timeout_sec());
        result.addProperty("edge_data_receive_timeout_sec", src.getEdge_data_receive_timeout_sec());
        result.addProperty("edge_first_byte_timeout_sec", src.getEdge_first_byte_timeout_sec());
        result.addProperty("edge_sdk_domain", src.getEdge_sdk_domain());
        result.addProperty("edge_quic_udp_port", src.getEdge_quic_udp_port());
        result.addProperty("edge_failures_monitoring_interval_sec", src.getEdge_failures_monitoring_interval_sec());
        result.addProperty("edge_failures_failover_threshold_percent", src.getEdge_failures_failover_threshold_percent());
        return result;
    }
}
