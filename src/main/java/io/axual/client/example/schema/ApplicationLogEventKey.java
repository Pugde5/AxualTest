/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package io.axual.client.example.schema;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

/** Identification of am ApplicationLogEvent system */
@org.apache.avro.specific.AvroGenerated
public class ApplicationLogEventKey extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -2050235326069258794L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ApplicationLogEventKey\",\"namespace\":\"io.axual.client.example.schema\",\"doc\":\"Identification of am ApplicationLogEvent system\",\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"The name of the application generating the LogEvent\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<ApplicationLogEventKey> ENCODER =
      new BinaryMessageEncoder<ApplicationLogEventKey>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<ApplicationLogEventKey> DECODER =
      new BinaryMessageDecoder<ApplicationLogEventKey>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<ApplicationLogEventKey> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<ApplicationLogEventKey> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<ApplicationLogEventKey> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<ApplicationLogEventKey>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this ApplicationLogEventKey to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a ApplicationLogEventKey from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a ApplicationLogEventKey instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static ApplicationLogEventKey fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** The name of the application generating the LogEvent */
   private java.lang.CharSequence name;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public ApplicationLogEventKey() {}

  /**
   * All-args constructor.
   * @param name The name of the application generating the LogEvent
   */
  public ApplicationLogEventKey(java.lang.CharSequence name) {
    this.name = name;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return name;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: name = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'name' field.
   * @return The name of the application generating the LogEvent
   */
  public java.lang.CharSequence getName() {
    return name;
  }


  /**
   * Sets the value of the 'name' field.
   * The name of the application generating the LogEvent
   * @param value the value to set.
   */
  public void setName(java.lang.CharSequence value) {
    this.name = value;
  }

  /**
   * Creates a new ApplicationLogEventKey RecordBuilder.
   * @return A new ApplicationLogEventKey RecordBuilder
   */
  public static io.axual.client.example.schema.ApplicationLogEventKey.Builder newBuilder() {
    return new io.axual.client.example.schema.ApplicationLogEventKey.Builder();
  }

  /**
   * Creates a new ApplicationLogEventKey RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ApplicationLogEventKey RecordBuilder
   */
  public static io.axual.client.example.schema.ApplicationLogEventKey.Builder newBuilder(io.axual.client.example.schema.ApplicationLogEventKey.Builder other) {
    if (other == null) {
      return new io.axual.client.example.schema.ApplicationLogEventKey.Builder();
    } else {
      return new io.axual.client.example.schema.ApplicationLogEventKey.Builder(other);
    }
  }

  /**
   * Creates a new ApplicationLogEventKey RecordBuilder by copying an existing ApplicationLogEventKey instance.
   * @param other The existing instance to copy.
   * @return A new ApplicationLogEventKey RecordBuilder
   */
  public static io.axual.client.example.schema.ApplicationLogEventKey.Builder newBuilder(io.axual.client.example.schema.ApplicationLogEventKey other) {
    if (other == null) {
      return new io.axual.client.example.schema.ApplicationLogEventKey.Builder();
    } else {
      return new io.axual.client.example.schema.ApplicationLogEventKey.Builder(other);
    }
  }

  /**
   * RecordBuilder for ApplicationLogEventKey instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ApplicationLogEventKey>
    implements org.apache.avro.data.RecordBuilder<ApplicationLogEventKey> {

    /** The name of the application generating the LogEvent */
    private java.lang.CharSequence name;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(io.axual.client.example.schema.ApplicationLogEventKey.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
    }

    /**
     * Creates a Builder by copying an existing ApplicationLogEventKey instance
     * @param other The existing instance to copy.
     */
    private Builder(io.axual.client.example.schema.ApplicationLogEventKey other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
    }

    /**
      * Gets the value of the 'name' field.
      * The name of the application generating the LogEvent
      * @return The value.
      */
    public java.lang.CharSequence getName() {
      return name;
    }


    /**
      * Sets the value of the 'name' field.
      * The name of the application generating the LogEvent
      * @param value The value of 'name'.
      * @return This builder.
      */
    public io.axual.client.example.schema.ApplicationLogEventKey.Builder setName(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.name = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * The name of the application generating the LogEvent
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'name' field.
      * The name of the application generating the LogEvent
      * @return This builder.
      */
    public io.axual.client.example.schema.ApplicationLogEventKey.Builder clearName() {
      name = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ApplicationLogEventKey build() {
      try {
        ApplicationLogEventKey record = new ApplicationLogEventKey();
        record.name = fieldSetFlags()[0] ? this.name : (java.lang.CharSequence) defaultValue(fields()[0]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<ApplicationLogEventKey>
    WRITER$ = (org.apache.avro.io.DatumWriter<ApplicationLogEventKey>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<ApplicationLogEventKey>
    READER$ = (org.apache.avro.io.DatumReader<ApplicationLogEventKey>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.name);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.name = in.readString(this.name instanceof Utf8 ? (Utf8)this.name : null);

    } else {
      for (int i = 0; i < 1; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.name = in.readString(this.name instanceof Utf8 ? (Utf8)this.name : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










