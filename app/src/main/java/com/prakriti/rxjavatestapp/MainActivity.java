package com.prakriti.rxjavatestapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;

public class MainActivity extends AppCompatActivity {
// lambda helps simplify code & make it concise & maintainable

    @BindView (R.id.textview) TextView textView;
    @BindView (R.id.recycler_view) RecyclerView recyclerView; // import the correct package

    private LinearLayoutManager linearLayoutManager;
    private RVCustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this); // this HAS to be the first line

        linearLayoutManager = new LinearLayoutManager(this);
        customAdapter = new RVCustomAdapter();

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(customAdapter);

// modified to use lambda functions -> external RetroLambda library
      //  Observable.just("Entry Information").subscribe(s -> textView.setText(s));
        // or
        Observable.just("ENTRY DETAILS").subscribe(textView::setText);

//        Observable.just("Entry Information") // from io.reactivex/ package
//                // Observable is the data source
//                // subscribe listens to the data
//                .subscribe(new Consumer<String>() { // Consumer is an interface -> callback
//                    // it consumes the item added to just()
//                    @Override
//                    public void accept(String s) throws Throwable {
//                        // to access data
//                        textView.setText(s);
//                    }
//                });

        // use reactive code to populate recycler view
//        Observable.just("Jake", "Amy", "Rosa", "Charles", "Terry", "Gina", "Holt")
//            .subscribe(new Consumer<String>() {
//                @Override
//                public void accept(String s) throws Throwable {
//                    customAdapter.addStringToList(s); // populates recycler with data passed here
//                }
//            });

        // create entries to populate recycler view
        Entry entry1 = new Entry("Samsung", BigDecimal.valueOf(1500), new Date()); // new Date() gives current date
        Entry entry2 = new Entry("RedMI", BigDecimal.valueOf(1800), new Date());
        Entry entry3 = new Entry("iPhone", BigDecimal.valueOf(2900), new Date());
        Entry entry4 = new Entry("Vivo", BigDecimal.valueOf(900), new Date());

        // modified to use lambda fns
        Observable.just(entry1, entry2, entry3, entry4).subscribe(customAdapter::addEntryToList);
        // or (s->customAdapter.addEntryToList(s))

//        Observable.just(entry1, entry2,entry3, entry4)
//                .subscribe(new Consumer<Entry>() {
//                    @Override
//                    public void accept(Entry entry) throws Throwable {
//                        customAdapter.addEntryToList(entry);
//                    }
//                });
    }

}