package com.rev.revsdk.config;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by victor on 03.02.17.
 */
public class ConfigParamenetrs {
    private String sdk_release_version;
    private String logging_level;
    private String configuration_api_url;
    private int configuration_refresh_interval_sec;
    private int configuration_request_timeout_sec;
    private int configuration_stale_timeout_sec;
    private String edge_host;
    private OperationMode operation_mode;
    private ListString allowed_transport_protocols;
    private String initial_transport_protocol;
    private String transport_monitoring_url;
    private String stats_reporting_url;
    private int stats_reporting_interval_sec;
    private String stats_reporting_level;
    private int stats_reporting_max_requests_per_report;
    private ListString domains_provisioned_list;
    private ListString domains_white_list;
    private ListString domains_black_list;
    private ListString internal_domains_black_list;
    private int a_b_testing_origin_offload_ratio;
    private int edge_connect_timeout_sec = 10;
    private int edge_data_receive_timeout_sec = 60;
    private int edge_first_byte_timeout_sec = 60;
    private String edge_sdk_domain = "revsdk.net";
    private int edge_quic_udp_port = 443;
    private int edge_failures_monitoring_interval_sec = 120;
    private int edge_failures_failover_threshold_percent = 80;

    public String getSdk_release_version() {
        return sdk_release_version;
    }

    public void setSdk_release_version(String sdk_release_version) {
        this.sdk_release_version = sdk_release_version;
    }

    public String getLogging_level() {
        return logging_level;
    }

    public void setLogging_level(String logging_level) {
        this.logging_level = logging_level;
    }

    public String getConfiguration_api_url() {
        return configuration_api_url;
    }

    public void setConfiguration_api_url(String configuration_api_url) {
        this.configuration_api_url = configuration_api_url;
    }

    public int getConfiguration_refresh_interval_sec() {
        return configuration_refresh_interval_sec;
    }

    public void setConfiguration_refresh_interval_sec(int configuration_refresh_interval_sec) {
        this.configuration_refresh_interval_sec = configuration_refresh_interval_sec;
    }

    public int getConfiguration_request_timeout_sec() {
        return configuration_request_timeout_sec;
    }

    public void setConfiguration_request_timeout_sec(int configuration_request_timeout_sec) {
        this.configuration_request_timeout_sec = configuration_request_timeout_sec;
    }

    public int getConfiguration_stale_timeout_sec() {
        return configuration_stale_timeout_sec;
    }

    public void setConfiguration_stale_timeout_sec(int configuration_stale_timeout_sec) {
        this.configuration_stale_timeout_sec = configuration_stale_timeout_sec;
    }

    public String getEdge_host() {
        return edge_host;
    }

    public void setEdge_host(String edge_host) {
        this.edge_host = edge_host;
    }

    public OperationMode getOperation_mode() {
        return operation_mode;
    }

    public void setOperation_mode(OperationMode operation_mode) {
        this.operation_mode = operation_mode;
    }

    public ListString getAllowed_transport_protocols() {
        return allowed_transport_protocols;
    }

    public void setAllowed_transport_protocols(ListString allowed_transport_protocols) {
        this.allowed_transport_protocols = allowed_transport_protocols;
    }

    public String getInitial_transport_protocol() {
        return initial_transport_protocol;
    }

    public void setInitial_transport_protocol(String initial_transport_protocol) {
        this.initial_transport_protocol = initial_transport_protocol;
    }

    public String getTransport_monitoring_url() {
        return transport_monitoring_url;
    }

    public void setTransport_monitoring_url(String transport_monitoring_url) {
        this.transport_monitoring_url = transport_monitoring_url;
    }

    public String getStats_reporting_url() {
        return stats_reporting_url;
    }

    public void setStats_reporting_url(String stats_reporting_url) {
        this.stats_reporting_url = stats_reporting_url;
    }

    public int getStats_reporting_interval_sec() {
        return stats_reporting_interval_sec;
    }

    public void setStats_reporting_interval_sec(int stats_reporting_interval_sec) {
        this.stats_reporting_interval_sec = stats_reporting_interval_sec;
    }

    public String getStats_reporting_level() {
        return stats_reporting_level;
    }

    public void setStats_reporting_level(String stats_reporting_level) {
        this.stats_reporting_level = stats_reporting_level;
    }

    public int getStats_reporting_max_requests_per_report() {
        return stats_reporting_max_requests_per_report;
    }

    public void setStats_reporting_max_requests_per_report(int stats_reporting_max_requests_per_report) {
        this.stats_reporting_max_requests_per_report = stats_reporting_max_requests_per_report;
    }

    public ListString getDomains_provisioned_list() {
        return domains_provisioned_list;
    }

    public void setDomains_provisioned_list(ListString domains_provisioned_list) {
        this.domains_provisioned_list = domains_provisioned_list;
    }

    public ListString getDomains_white_list() {
        return domains_white_list;
    }

    public void setDomains_white_list(ListString domains_white_list) {
        this.domains_white_list = domains_white_list;
    }

    public ListString getDomains_black_list() {
        return domains_black_list;
    }

    public void setDomains_black_list(ListString domains_black_list) {
        this.domains_black_list = domains_black_list;
    }

    public ListString getInternal_domains_black_list() {
        return internal_domains_black_list;
    }

    public void setInternal_domains_black_list(ListString internal_domains_black_list) {
        this.internal_domains_black_list = internal_domains_black_list;
    }

    public int getA_b_testing_origin_offload_ratio() {
        return a_b_testing_origin_offload_ratio;
    }

    public void setA_b_testing_origin_offload_ratio(int a_b_testing_origin_offload_ratio) {
        this.a_b_testing_origin_offload_ratio = a_b_testing_origin_offload_ratio;
    }

    public int getEdge_connect_timeout_sec() {
        return edge_connect_timeout_sec;
    }

    public void setEdge_connect_timeout_sec(int edge_connect_timeout_sec) {
        this.edge_connect_timeout_sec = edge_connect_timeout_sec;
    }

    public int getEdge_data_receive_timeout_sec() {
        return edge_data_receive_timeout_sec;
    }

    public void setEdge_data_receive_timeout_sec(int edge_data_receive_timeout_sec) {
        this.edge_data_receive_timeout_sec = edge_data_receive_timeout_sec;
    }

    public int getEdge_first_byte_timeout_sec() {
        return edge_first_byte_timeout_sec;
    }

    public void setEdge_first_byte_timeout_sec(int edge_first_byte_timeout_sec) {
        this.edge_first_byte_timeout_sec = edge_first_byte_timeout_sec;
    }

    public String getEdge_sdk_domain() {
        return edge_sdk_domain;
    }

    public void setEdge_sdk_domain(String edge_sdk_domain) {
        this.edge_sdk_domain = edge_sdk_domain;
    }

    public int getEdge_quic_udp_port() {
        return edge_quic_udp_port;
    }

    public void setEdge_quic_udp_port(int edge_quic_udp_port) {
        this.edge_quic_udp_port = edge_quic_udp_port;
    }

    public int getEdge_failures_monitoring_interval_sec() {
        return edge_failures_monitoring_interval_sec;
    }

    public void setEdge_failures_monitoring_interval_sec(int edge_failures_monitoring_interval_sec) {
        this.edge_failures_monitoring_interval_sec = edge_failures_monitoring_interval_sec;
    }

    public int getEdge_failures_failover_threshold_percent() {
        return edge_failures_failover_threshold_percent;
    }

    public void setEdge_failures_failover_threshold_percent(int edge_failures_failover_threshold_percent) {
        this.edge_failures_failover_threshold_percent = edge_failures_failover_threshold_percent;
    }
}
