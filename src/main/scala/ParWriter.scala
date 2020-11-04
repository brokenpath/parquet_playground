import org.apache.parquet.io.InputFile
//import org.apache.parquet.schema.Types.{ Builder => OriginalType}
import org.apache.parquet.schema.Types
import org.apache.parquet.schema.PrimitiveType.PrimitiveTypeName._
import org.apache.parquet.schema.LogicalTypeAnnotation._
import org.apache.parquet.schema._
import org.apache.parquet.schema.Type.Repetition
import org.apache.hadoop.fs.Path;
import org.apache.parquet.hadoop.ParquetWriter
import java.io.File
import org.apache.parquet.hadoop.metadata.CompressionCodecName



class MyWriter(path: Path, schema: MessageType, compression: CompressionCodecName) extends ParquetWriter.Builder[List[String], MyWriter](path){
    self().withCompressionCodec(compression)
    override def self(): MyWriter = this
    override def getWriteSupport(conf: org.apache.hadoop.conf.Configuration) : org.apache.parquet.hadoop.api.WriteSupport[List[String]] = ???
}


object ParWriter extends App {
    
    val parquetSchema = "message m { required INT64 id; required binary letter; }"

    print("WEEEE")
    create_map_of_integer_string_pairs()
    def create_map_of_integer_string_pairs() {
        val letter = Types.required(BINARY).as(stringType()).named("letter")
        val number = Types.required(INT32).named("number")
        val map =  Types.buildGroup(Repetition.REQUIRED).as(LogicalTypeAnnotation.mapType()).addFields(number, letter).named("number_letters")
        print(map.toString())
        
    }


    def get_parquet_writer(schema : MessageType, outputDirectoryPath : String) = {
        val outputFilePath = outputDirectoryPath + "/" + System.currentTimeMillis() + ".parquet";
        val outputParquetFile = new File(outputFilePath);
        val path = new Path(outputParquetFile.toURI().toString());
        new MyWriter(path, schema, CompressionCodecName.UNCOMPRESSED)
    }






    

}