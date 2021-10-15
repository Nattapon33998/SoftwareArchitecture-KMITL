package creational;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
public class JSONBookMetadataFormatter implements BookMetadataFormatter {
    JSONObject obj;
    JSONArray array;

    public JSONBookMetadataFormatter() {
        reset();
    }
    @Override
    public BookMetadataFormatter reset() {
        obj = new JSONObject();
        array = new JSONArray();
        obj.put("Books",array);
        return this;
    }

    @Override
    public BookMetadataFormatter append(Book b) {
        JSONObject obj_list = new JSONObject();
        JSONArray author_list = new JSONArray();
        for(int i=0;i<b.getAuthors().length;i++){
            author_list.add(b.getAuthors()[i]);
        }
        obj_list.put("ISBN",b.getISBN());
        obj_list.put("Authors",author_list);
        obj_list.put("Title",b.getTitle());
        obj_list.put("Publisher",b.getPublisher());

        array.add(obj_list);
        return this;
    }

    @Override
    public String getMetadataString() {

        return obj.toString();
    }
}