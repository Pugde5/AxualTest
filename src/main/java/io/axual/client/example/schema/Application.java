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

/** Identification of an application */
@org.apache.avro.specific.AvroGenerated
public class Application extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -1359236434068030962L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Application\",\"namespace\":\"io.axual.client.example.schema\",\"doc\":\"Identification of an application\",\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"The name of the application\"},{\"name\":\"version\",\"type\":[\"null\",\"string\"],\"doc\":\"(Optional) The application version\",\"default\":null},{\"name\":\"owner\",\"type\":[\"null\",\"string\"],\"doc\":\"The owner of the application\",\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Application> ENCODER =
      new BinaryMessageEncoder<Application>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Application> DECODER =
      new BinaryMessageDecoder<Application>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Application> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Application> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Application> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Application>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Application to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Application from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Application instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Application fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** The name of the application */
   private java.lang.CharSequence name;
  /** (Optional) The application version */
   private java.lang.CharSequence version;
  /** The owner of the application */
   private java.lang.CharSequence owner;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Application() {}

  /**
   * All-args constructor.
   * @param name The name of the application
   * @param version (Optional) The application version
   * @param owner The owner of the application
   */
  public Application(java.lang.CharSequence name, java.lang.CharSequence version, java.lang.CharSequence owner) {
    this.name = name;
    this.version = version;
    this.owner = owner;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return name;
    case 1: return version;
    case 2: return owner;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: name = (java.lang.CharSequence)value$; break;
    case 1: version = (java.lang.CharSequence)value$; break;
    case 2: owner = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'name' field.
   * @return The name of the application
   */
  public java.lang.CharSequence getName() {
    return name;
  }


  /**
   * Sets the value of the 'name' field.
   * The name of the application
   * @param value the value to set.
   */
  public void setName(java.lang.CharSequence value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'version' field.
   * @return (Optional) The application version
   */
  public java.lang.CharSequence getVersion() {
    return version;
  }


  /**
   * Sets the value of the 'version' field.
   * (Optional) The application version
   * @param value the value to set.
   */
  public void setVersion(java.lang.CharSequence value) {
    this.version = value;
  }

  /**
   * Gets the value of the 'owner' field.
   * @return The owner of the application
   */
  public java.lang.CharSequence getOwner() {
    return owner;
  }


  /**
   * Sets the value of the 'owner' field.
   * The owner of the application
   * @param value the value to set.
   */
  public void setOwner(java.lang.CharSequence value) {
    this.owner = value;
  }

  /**
   * Creates a new Application RecordBuilder.
   * @return A new Application RecordBuilder
   */
  public static io.axual.client.example.schema.Application.Builder newBuilder() {
    return new io.axual.client.example.schema.Application.Builder();
  }

  /**
   * Creates a new Application RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Application RecordBuilder
   */
  public static io.axual.client.example.schema.Application.Builder newBuilder(io.axual.client.example.schema.Application.Builder other) {
    if (other == null) {
      return new io.axual.client.example.schema.Application.Builder();
    } else {
      return new io.axual.client.example.schema.Application.Builder(other);
    }
  }

  /**
   * Creates a new Application RecordBuilder by copying an existing Application instance.
   * @param other The existing instance to copy.
   * @return A new Application RecordBuilder
   */
  public static io.axual.client.example.schema.Application.Builder newBuilder(io.axual.client.example.schema.Application other) {
    if (other == null) {
      return new io.axual.client.example.schema.Application.Builder();
    } else {
      return new io.axual.client.example.schema.Application.Builder(other);
    }
  }

  /**
   * RecordBuilder for Application instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Application>
    implements org.apache.avro.data.RecordBuilder<Application> {

    /** The name of the application */
    private java.lang.CharSequence name;
    /** (Optional) The application version */
    private java.lang.CharSequence version;
    /** The owner of the application */
    private java.lang.CharSequence owner;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(io.axual.client.example.schema.Application.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.version)) {
        this.version = data().deepCopy(fields()[1].schema(), other.version);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.owner)) {
        this.owner = data().deepCopy(fields()[2].schema(), other.owner);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing Application instance
     * @param other The existing instance to copy.
     */
    private Builder(io.axual.client.example.schema.Application other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.version)) {
        this.version = data().deepCopy(fields()[1].schema(), other.version);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.owner)) {
        this.owner = data().deepCopy(fields()[2].schema(), other.owner);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'name' field.
      * The name of the application
      * @return The value.
      */
    public java.lang.CharSequence getName() {
      return name;
    }


    /**
      * Sets the value of the 'name' field.
      * The name of the application
      * @param value The value of 'name'.
      * @return This builder.
      */
    public io.axual.client.example.schema.Application.Builder setName(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.name = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * The name of the application
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'name' field.
      * The name of the application
      * @return This builder.
      */
    public io.axual.client.example.schema.Application.Builder clearName() {
      name = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'version' field.
      * (Optional) The application version
      * @return The value.
      */
    public java.lang.CharSequence getVersion() {
      return version;
    }


    /**
      * Sets the value of the 'version' field.
      * (Optional) The application version
      * @param value The value of 'version'.
      * @return This builder.
      */
    public io.axual.client.example.schema.Application.Builder setVersion(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.version = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'version' field has been set.
      * (Optional) The application version
      * @return True if the 'version' field has been set, false otherwise.
      */
    public boolean hasVersion() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'version' field.
      * (Optional) The application version
      * @return This builder.
      */
    public io.axual.client.example.schema.Application.Builder clearVersion() {
      version = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'owner' field.
      * The owner of the application
      * @return The value.
      */
    public java.lang.CharSequence getOwner() {
      return owner;
    }


    /**
      * Sets the value of the 'owner' field.
      * The owner of the application
      * @param value The value of 'owner'.
      * @return This builder.
      */
    public io.axual.client.example.schema.Application.Builder setOwner(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.owner = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'owner' field has been set.
      * The owner of the application
      * @return True if the 'owner' field has been set, false otherwise.
      */
    public boolean hasOwner() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'owner' field.
      * The owner of the application
      * @return This builder.
      */
    public io.axual.client.example.schema.Application.Builder clearOwner() {
      owner = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Application build() {
      try {
        Application record = new Application();
        record.name = fieldSetFlags()[0] ? this.name : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.version = fieldSetFlags()[1] ? this.version : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.owner = fieldSetFlags()[2] ? this.owner : (java.lang.CharSequence) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Application>
    WRITER$ = (org.apache.avro.io.DatumWriter<Application>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Application>
    READER$ = (org.apache.avro.io.DatumReader<Application>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.name);

    if (this.version == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.version);
    }

    if (this.owner == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.owner);
    }

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.name = in.readString(this.name instanceof Utf8 ? (Utf8)this.name : null);

      if (in.readIndex() != 1) {
        in.readNull();
        this.version = null;
      } else {
        this.version = in.readString(this.version instanceof Utf8 ? (Utf8)this.version : null);
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.owner = null;
      } else {
        this.owner = in.readString(this.owner instanceof Utf8 ? (Utf8)this.owner : null);
      }

    } else {
      for (int i = 0; i < 3; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.name = in.readString(this.name instanceof Utf8 ? (Utf8)this.name : null);
          break;

        case 1:
          if (in.readIndex() != 1) {
            in.readNull();
            this.version = null;
          } else {
            this.version = in.readString(this.version instanceof Utf8 ? (Utf8)this.version : null);
          }
          break;

        case 2:
          if (in.readIndex() != 1) {
            in.readNull();
            this.owner = null;
          } else {
            this.owner = in.readString(this.owner instanceof Utf8 ? (Utf8)this.owner : null);
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










