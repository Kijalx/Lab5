package ie.atu.lab5;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeignService {
    private final TodoClient todoClient;
    List<TodoResponse> resp = new ArrayList<>();
    public FeignService(TodoClient todoClient) {
        this.todoClient = todoClient;
    }

    public TodoResponse fetchData(){
        TodoResponse td = todoClient.fetchData();
        System.out.println(td);

        try{
            Thread.sleep(2000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        return td;
    }

    public List<TodoResponse> fetchAllData(){
        return todoClient.fetchAllData();
    }

    public TodoResponse fetchDataById(int id){
        return todoClient.fetchDataById(id);
    }

    public TodoResponse extractFromList(int id){
        resp = todoClient.fetchAllData();
        return resp.get(id - 1);
    }
}
