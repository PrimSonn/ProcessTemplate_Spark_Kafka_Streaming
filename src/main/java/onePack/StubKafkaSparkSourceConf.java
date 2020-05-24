package onePack;

import com.google.common.collect.ImmutableList;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.List;

//TODO: rewrite
public class StubKafkaSparkSourceConf implements KafkaSparkDirectSourceConf_0_10 {

	private final String groupId;

	private final String clientId;

	private final String bootStrapServers;

	private final ImmutableList<String> topicList;

	private final Class<? extends Deserializer<?>> keyDeserializer;

	private final Class<? extends Deserializer<?>> valueDeserializer;

	private StubKafkaSparkSourceConf
			(String groupId, String clientId, String bootStrapServers, List<String> topicList
					, String autoOffsetResetConf
					, Class<? extends Deserializer<?>> keyDeserializer
					, Class<? extends Deserializer<?>> valueDeserializer) {

		this.groupId = groupId;
		this.clientId = clientId;
		this.bootStrapServers = bootStrapServers;
		this.topicList = ImmutableList.copyOf(topicList);
		this.keyDeserializer = keyDeserializer;
		this.valueDeserializer = valueDeserializer;
	}


	@Override
	public String getGroupId() {
		return this.groupId;
	}

	@Override
	public String getClientId() {
		return this.clientId;
	}

	@Override
	public AUTO_OFFSET_RESET_VAL getAutoOffsetResetConf() {
		return null;
	}

	@Override
	public String getBootstrapServers() {
		return this.bootStrapServers;
	}

	@Override
	public void printErrorMessage(String msg) {

	}

	@Override
	public ImmutableList<String> getTopicList() {
		return this.topicList;
	}

	@Override
	public Class<? extends Deserializer<?>> getKeyDeserializer() {
		return this.keyDeserializer;
	}

	@Override
	public Class<? extends Deserializer<?>> getValueDeserializer() {
		return this.valueDeserializer;
	}

	public static class StubKafkaSourceConfBuilder {

		private String groupId;
		private String clientId;
		private String bootStrapServers;
		private String autoOffsetResetConf;
		private List<String> topicList;
		private Class<? extends Deserializer<?>> keyDeserializer;
		private Class<? extends Deserializer<?>> valueDeserializer;

		StubKafkaSparkSourceConf build() throws IncompleteBuildResourceException {

			if (!this.preBuildCheck()) throw new IncompleteBuildResourceException();

			StubKafkaSparkSourceConf result
					= new StubKafkaSparkSourceConf(this.groupId, this.clientId, this.bootStrapServers, this.topicList
					, this.autoOffsetResetConf, this.keyDeserializer, this.valueDeserializer);
			this.clear();

			return result;
		}

		public boolean preBuildCheck() {

			boolean result = true;

			if (this.groupId == null) {
				System.err.println("null groupId");
				result = false;
			}

			if (this.clientId == null) {
				System.err.println("null clientId");
				result = false;
			}

			if (this.autoOffsetResetConf == null) {
				System.err.println("null autoOffsetResetConf");
				result = false;
			}

			if (this.topicList == null) {
				System.err.println("null topicList");
				result = false;
			} else if (this.topicList.isEmpty()) {
				System.err.println("empty topicList!");
				result = false;
			}

			if (this.keyDeserializer == null) {
				System.err.println("null keyDeserializer");
				result = false;
			}

			if (this.valueDeserializer == null) {
				System.err.println("null valueDeserializer");
				result = false;
			}

			return result;
		}

		public void clear() {
			this.groupId = null;
			this.clientId = null;
			this.bootStrapServers = null;
			this.autoOffsetResetConf = null;
			this.topicList.clear();
			this.topicList = null;
			this.keyDeserializer = null;
			this.valueDeserializer = null;
		}

		public StubKafkaSourceConfBuilder setGroupId(String groupId) {
			this.groupId = groupId;
			return this;
		}

		public StubKafkaSourceConfBuilder setClientId(String clientId) {
			this.clientId = clientId;
			return this;
		}

		public StubKafkaSourceConfBuilder setBootStrapServers(String bootStrapServers) {
			this.bootStrapServers = bootStrapServers;
			return this;
		}

		public StubKafkaSourceConfBuilder setTopicList(List<String> topicList) {
			this.topicList = topicList;
			return this;
		}

		public StubKafkaSourceConfBuilder setKeyDeserializer(Class<? extends Deserializer<?>> keyDeserializer) {
			this.keyDeserializer = keyDeserializer;
			return this;
		}

		public StubKafkaSourceConfBuilder setValueDeserializer(Class<? extends Deserializer<?>> valueDeserializer) {
			this.valueDeserializer = valueDeserializer;
			return this;
		}

		public String getGroupId() {return this.groupId;}
		public String getClientId() {return this.clientId;}
		public String getBootStrapServers() {return this.bootStrapServers;}
		public List<String> getTopicList() {return this.topicList;}
		public Class<? extends Deserializer<?>> getKeyDeserializer() {return this.keyDeserializer;}
		public Class<? extends Deserializer<?>> getValueDeserializer() {return this.valueDeserializer;}
	}

	private static class IncompleteBuildResourceException extends Exception {
	}
}
