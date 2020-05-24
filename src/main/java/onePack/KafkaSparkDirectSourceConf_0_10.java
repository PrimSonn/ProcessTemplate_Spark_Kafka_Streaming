package onePack;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Deserializer;

public interface KafkaSparkDirectSourceConf_0_10 extends KafkaSparkDirectSourceConfiguration {

	KafkaSparkStreamingConfVersion KAFKA_SPARK_VERSION = KafkaSparkStreamingConfVersion.V_0_10;

	boolean ENABLE_AUTO_COMMIT_CONFIG_VAL = false;

	String getBootstrapServers();

	ImmutableList<String> getTopicList();

	Class<? extends Deserializer<?>> getKeyDeserializer();

	Class<? extends Deserializer<?>> getValueDeserializer();

	@Override
	default boolean hasInvalidParameter() {

		// TODO: implement
		boolean result = true;

		if (getAutoOffsetResetConf().kafkaSparkStreamingConfVersion
				!= KafkaSparkDirectSourceConf_0_10.KAFKA_SPARK_VERSION) {

			printErrorMessage("TODO..");
			result = true;
		}

		return result;
	}

	@Override
	default ImmutableMap<String, Object> getSourceKafkaParam() throws WrongParameterSettingException {

		if (this.hasInvalidParameter()) { // TODO: implement
			final String errorMessage = "TODO ...";
			this.printErrorMessage(errorMessage);
			throw new WrongParameterSettingException(errorMessage);
		}

		return ImmutableMap.<String, Object>builder()
				.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, getBootstrapServers())
				.put(ConsumerConfig.GROUP_ID_CONFIG, getGroupId())
				.put(ConsumerConfig.CLIENT_ID_CONFIG, getClientId())
				.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG
						,KafkaSparkDirectSourceConf_0_10.ENABLE_AUTO_COMMIT_CONFIG_VAL)
				.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, getAutoOffsetResetConf().value)
				.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, getKeyDeserializer())
				.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, getValueDeserializer())
				.build();
	}
}
