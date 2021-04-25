package com.example.lab02_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<Employee> arrEmployee=new ArrayList<Employee>();
    //Sử dụng MyArrayAdapter thay thì ArrayAdapter
    EmployeeAdapter adapter=null;
    ListView lvNhanvien=null;

    Button btnAdd;
    EditText editMa,editTen;
    CheckBox chManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Find view
        btnAdd = (Button) findViewById(R.id.btnAdd);
        editMa = (EditText) findViewById(R.id.editMa);
        editTen = (EditText) findViewById(R.id.editTen);
        chManager = (CheckBox) findViewById(R.id.chManager);

        lvNhanvien = (ListView) findViewById(R.id.lvnhanvien);

        arrEmployee = new ArrayList<Employee>();

        //khởi tọa đối tượng adapter và gắn datasource
        adapter = new EmployeeAdapter(this, R.layout.item_employee, arrEmployee);

        // gắn adapter cho listview
        lvNhanvien.setAdapter(adapter);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                xulyNhap();
            }
        });







        //xử lý nhập


    }
    public void xulyNhap() {
        String ma=editMa.getText()+"";
        String ten=editTen.getText()+"";
        Boolean quanly = false;
        if (chManager.isChecked()) {
            quanly = true;


        }
        Employee emp = new Employee();
        emp.setId(ma);
        emp.setFullName(ten);
        emp.setManager(quanly);

        arrEmployee.add(emp);

        //gọi hàm cập nhật giao diện
        adapter.notifyDataSetChanged();
        //Sau khi update thì xóa trắng dữ liệu và cho editma focus
        editMa.setText("");
        editTen.setText("");
        editMa.requestFocus();
    }

}