package onePack;

public interface ManagerConfiguration
		extends BaseProcessConfig, KafkaSourceStreamProcessConfig, KafkaTargetStreamProcessConfig
		, IgniteClientProcessConfig, OracleCientProcessConfig {
}