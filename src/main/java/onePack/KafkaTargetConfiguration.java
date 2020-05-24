package onePack;

import com.google.common.collect.ImmutableMap;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.Serializer;

/**
 * for Kafka 0.10.x producer client
 */
public interface KafkaTargetConfiguration { // TODO parameter list check.

	String ACKS_CONF = "all";

	/**
	 * @return singleton(for each target cluster) producer.
	 */
	<K, V> KafkaProducer<K, V> getSingletonProducer();

	String getBootstrapServers();

	String getClientId();

	Class<? extends Serializer<?>> getKeySerializer();

	Class<? extends Serializer<?>> getValueSerializer();

	//TODO: custom partitioner? interceptor?

	/**
	 * @return int max.in.flight.requests.per.connection set 1 for in order processing
	 */
	int getMaxInFlightRequestsPerConn();

	default ImmutableMap<String, Object> getTargetKafkaParams() {

		return ImmutableMap.<String, Object>builder()
				.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, getBootstrapServers())
				.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, getKeySerializer())
				.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, getValueSerializer())
				.put(ProducerConfig.CLIENT_ID_CONFIG, getClientId())
				.put(ProducerConfig.ACKS_CONFIG, KafkaTargetConfiguration.ACKS_CONF)
				.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, getMaxInFlightRequestsPerConn())
				.build();
	}
}
