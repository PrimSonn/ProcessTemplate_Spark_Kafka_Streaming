package onePack;

import com.google.common.collect.ImmutableMap;

/**
 * base configuration template for an kafka spark direct streaming configuration
 * use sub interface
 */
public interface KafkaSparkDirectSourceConfiguration {

//	boolean ACKS_CONF = false;

	String getGroupId();

	String getClientId();

	AUTO_OFFSET_RESET_VAL getAutoOffsetResetConf();

	void printErrorMessage(String msg);

	boolean hasInvalidParameter();

	default ImmutableMap<String, Object> getSourceKafkaParam()
			throws WrongParameterSettingException, VersionNotSetException {

		final String errorMessage = "onePack/TODO ";
		printErrorMessage(errorMessage);
		throw new VersionNotSetException(errorMessage);
	}

	class VersionNotSetException extends Exception {
		VersionNotSetException(String reason) { super(reason); }
	}

	class WrongParameterSettingException extends Exception {
		WrongParameterSettingException(String reason) { super(reason); }
	}

	enum AUTO_OFFSET_RESET_VAL {

		LARGEST("largest", KafkaSparkStreamingConfVersion.V_0_8)
		,SMALLEST("smallest", KafkaSparkStreamingConfVersion.V_0_8)
		,LATEST("latest", KafkaSparkStreamingConfVersion.V_0_10)
		,EARLIEST("earliest", KafkaSparkStreamingConfVersion.V_0_10)
		,NONE("none", KafkaSparkStreamingConfVersion.V_0_10);

		String value;
		KafkaSparkStreamingConfVersion kafkaSparkStreamingConfVersion;

		AUTO_OFFSET_RESET_VAL(String value, KafkaSparkStreamingConfVersion kafkaSparkStreamingConfVersion) {
			this.value = value;
			this.kafkaSparkStreamingConfVersion = kafkaSparkStreamingConfVersion;
		}
	}

	enum KafkaSparkStreamingConfVersion {
		V_0_8
		,V_0_10
	}
}
