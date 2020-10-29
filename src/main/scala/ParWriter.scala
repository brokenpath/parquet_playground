import org.apache.parquet.io.InputFile
//import org.apache.parquet.schema.Types.{ Builder => OriginalType}
import org.apache.parquet.schema.Types
import org.apache.parquet.schema.PrimitiveType.PrimitiveTypeName._
import org.apache.parquet.schema.LogicalTypeAnnotation._
import org.apache.parquet.schema._
import org.apache.parquet.schema.Type.Repetition
import java.awt.PageAttributes.OriginType

object ParWriter extends App {
    
    print("WEEEE")
    create_map_of_integer_string_pairs()
    def create_map_of_integer_string_pairs() {
        val letter = Types.required(BINARY).as(stringType()).named("letter")
        val number = Types.required(INT32).named("number")
        val map =  Types.buildGroup(Repetition.REQUIRED).as(LogicalTypeAnnotation.mapType()).addFields(number, letter).named("number_letters")
        print(map.toString())
        
    }

    

}