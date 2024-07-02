/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.github.joanersoncosta.avro;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class BoletoAvro extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -8313737928036482775L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"BoletoAvro\",\"namespace\":\"com.github.joanersoncosta.avro\",\"fields\":[{\"name\":\"codigoBarras\",\"type\":\"string\"},{\"name\":\"situacaoBoleto\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<BoletoAvro> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<BoletoAvro> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<BoletoAvro> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<BoletoAvro> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<BoletoAvro> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this BoletoAvro to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a BoletoAvro from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a BoletoAvro instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static BoletoAvro fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.CharSequence codigoBarras;
  private int situacaoBoleto;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public BoletoAvro() {}

  /**
   * All-args constructor.
   * @param codigoBarras The new value for codigoBarras
   * @param situacaoBoleto The new value for situacaoBoleto
   */
  public BoletoAvro(java.lang.CharSequence codigoBarras, java.lang.Integer situacaoBoleto) {
    this.codigoBarras = codigoBarras;
    this.situacaoBoleto = situacaoBoleto;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return codigoBarras;
    case 1: return situacaoBoleto;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: codigoBarras = (java.lang.CharSequence)value$; break;
    case 1: situacaoBoleto = (java.lang.Integer)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'codigoBarras' field.
   * @return The value of the 'codigoBarras' field.
   */
  public java.lang.CharSequence getCodigoBarras() {
    return codigoBarras;
  }


  /**
   * Sets the value of the 'codigoBarras' field.
   * @param value the value to set.
   */
  public void setCodigoBarras(java.lang.CharSequence value) {
    this.codigoBarras = value;
  }

  /**
   * Gets the value of the 'situacaoBoleto' field.
   * @return The value of the 'situacaoBoleto' field.
   */
  public int getSituacaoBoleto() {
    return situacaoBoleto;
  }


  /**
   * Sets the value of the 'situacaoBoleto' field.
   * @param value the value to set.
   */
  public void setSituacaoBoleto(int value) {
    this.situacaoBoleto = value;
  }

  /**
   * Creates a new BoletoAvro RecordBuilder.
   * @return A new BoletoAvro RecordBuilder
   */
  public static com.github.joanersoncosta.avro.BoletoAvro.Builder newBuilder() {
    return new com.github.joanersoncosta.avro.BoletoAvro.Builder();
  }

  /**
   * Creates a new BoletoAvro RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new BoletoAvro RecordBuilder
   */
  public static com.github.joanersoncosta.avro.BoletoAvro.Builder newBuilder(com.github.joanersoncosta.avro.BoletoAvro.Builder other) {
    if (other == null) {
      return new com.github.joanersoncosta.avro.BoletoAvro.Builder();
    } else {
      return new com.github.joanersoncosta.avro.BoletoAvro.Builder(other);
    }
  }

  /**
   * Creates a new BoletoAvro RecordBuilder by copying an existing BoletoAvro instance.
   * @param other The existing instance to copy.
   * @return A new BoletoAvro RecordBuilder
   */
  public static com.github.joanersoncosta.avro.BoletoAvro.Builder newBuilder(com.github.joanersoncosta.avro.BoletoAvro other) {
    if (other == null) {
      return new com.github.joanersoncosta.avro.BoletoAvro.Builder();
    } else {
      return new com.github.joanersoncosta.avro.BoletoAvro.Builder(other);
    }
  }

  /**
   * RecordBuilder for BoletoAvro instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<BoletoAvro>
    implements org.apache.avro.data.RecordBuilder<BoletoAvro> {

    private java.lang.CharSequence codigoBarras;
    private int situacaoBoleto;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.github.joanersoncosta.avro.BoletoAvro.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.codigoBarras)) {
        this.codigoBarras = data().deepCopy(fields()[0].schema(), other.codigoBarras);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.situacaoBoleto)) {
        this.situacaoBoleto = data().deepCopy(fields()[1].schema(), other.situacaoBoleto);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
    }

    /**
     * Creates a Builder by copying an existing BoletoAvro instance
     * @param other The existing instance to copy.
     */
    private Builder(com.github.joanersoncosta.avro.BoletoAvro other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.codigoBarras)) {
        this.codigoBarras = data().deepCopy(fields()[0].schema(), other.codigoBarras);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.situacaoBoleto)) {
        this.situacaoBoleto = data().deepCopy(fields()[1].schema(), other.situacaoBoleto);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'codigoBarras' field.
      * @return The value.
      */
    public java.lang.CharSequence getCodigoBarras() {
      return codigoBarras;
    }


    /**
      * Sets the value of the 'codigoBarras' field.
      * @param value The value of 'codigoBarras'.
      * @return This builder.
      */
    public com.github.joanersoncosta.avro.BoletoAvro.Builder setCodigoBarras(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.codigoBarras = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'codigoBarras' field has been set.
      * @return True if the 'codigoBarras' field has been set, false otherwise.
      */
    public boolean hasCodigoBarras() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'codigoBarras' field.
      * @return This builder.
      */
    public com.github.joanersoncosta.avro.BoletoAvro.Builder clearCodigoBarras() {
      codigoBarras = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'situacaoBoleto' field.
      * @return The value.
      */
    public int getSituacaoBoleto() {
      return situacaoBoleto;
    }


    /**
      * Sets the value of the 'situacaoBoleto' field.
      * @param value The value of 'situacaoBoleto'.
      * @return This builder.
      */
    public com.github.joanersoncosta.avro.BoletoAvro.Builder setSituacaoBoleto(int value) {
      validate(fields()[1], value);
      this.situacaoBoleto = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'situacaoBoleto' field has been set.
      * @return True if the 'situacaoBoleto' field has been set, false otherwise.
      */
    public boolean hasSituacaoBoleto() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'situacaoBoleto' field.
      * @return This builder.
      */
    public com.github.joanersoncosta.avro.BoletoAvro.Builder clearSituacaoBoleto() {
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public BoletoAvro build() {
      try {
        BoletoAvro record = new BoletoAvro();
        record.codigoBarras = fieldSetFlags()[0] ? this.codigoBarras : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.situacaoBoleto = fieldSetFlags()[1] ? this.situacaoBoleto : (java.lang.Integer) defaultValue(fields()[1]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<BoletoAvro>
    WRITER$ = (org.apache.avro.io.DatumWriter<BoletoAvro>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<BoletoAvro>
    READER$ = (org.apache.avro.io.DatumReader<BoletoAvro>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.codigoBarras);

    out.writeInt(this.situacaoBoleto);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.codigoBarras = in.readString(this.codigoBarras instanceof Utf8 ? (Utf8)this.codigoBarras : null);

      this.situacaoBoleto = in.readInt();

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.codigoBarras = in.readString(this.codigoBarras instanceof Utf8 ? (Utf8)this.codigoBarras : null);
          break;

        case 1:
          this.situacaoBoleto = in.readInt();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}









