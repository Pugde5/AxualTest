/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package io.axual.client.example.schema;
/** The level of the log message */
@org.apache.avro.specific.AvroGenerated
public enum ApplicationLogLevel implements org.apache.avro.generic.GenericEnumSymbol<ApplicationLogLevel> {
  DEBUG, INFO, WARN, ERROR, FATAL  ;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"ApplicationLogLevel\",\"namespace\":\"io.axual.client.example.schema\",\"doc\":\"The level of the log message\",\"symbols\":[\"DEBUG\",\"INFO\",\"WARN\",\"ERROR\",\"FATAL\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
}
