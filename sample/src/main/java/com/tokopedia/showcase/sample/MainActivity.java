package com.tokopedia.showcase.sample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.tokopedia.showcase.ShowCaseContentPosition;
import com.tokopedia.showcase.ShowCaseDialog;
import com.tokopedia.showcase.ShowCaseBuilder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener{

    private Toolbar toolbar;

//    private Button buttonHello;
//    private TextView textDescription;
//    private Button buttonShow;
    private FloatingActionButton fab;

    private ArrayList<ShowCaseDialog.TutorObject> showCaseList;

    private ShowCaseDialog showCaseDialog;
    private RecyclerView recyclerView;
    private LinearLayoutManager llm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initShowCaseDialog();
    }

    private void initShowCaseDialog() {
        showCaseDialog = new ShowCaseBuilder()
                .textColorRes(android.R.color.white)
                .shadowColorRes(R.color.shadow)
                .titleTextSizeRes(R.dimen.text_title)
                .textSizeRes(R.dimen.text_normal)
                .spacingRes(R.dimen.spacing_normal)
                .backgroundContentColorRes(R.color.blue)
                .circleIndicatorBackgroundDrawableRes(R.drawable.selector_circle_green)
                .prevStringRes(R.string.previous2)
                .nextStringRes(R.string.next2)
                .finishStringRes(R.string.finish2)
                .useCircleIndicator(true)
                .clickable(true)
                .build();
    }

    private void initViews() {
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.fab = (FloatingActionButton) findViewById(R.id.fab);

        View buttonShowCase = findViewById(R.id.button_show_case);
        buttonShowCase.setOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        llm = new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(llm);

        SampleAdapter adapter = new SampleAdapter(Util.getSampleData());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        showCaseList = new ArrayList<>();
        showCaseList.add(new ShowCaseDialog.TutorObject(
                toolbar,
                null,
                "Above is the <b>toolbar</b>.<br/><br/>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suo enim quisque studio maxime ducitur. Scio enim esse quosdam, qui quavis lingua philosophari possint; Animum autem reliquis rebus ita perfecit, ut corpus; Quo modo autem optimum, si bonum praeterea nullum est? Dicet pro me ipsa virtus nec dubitabit isti vestro beato M. Sic enim censent, oportunitatis esse beate vivere."));
        showCaseList.add(new ShowCaseDialog.TutorObject(
                fab,
                "This is example Title",
                "This description point to <font color=\"#FF0000\"> Floating Action Button </font> on the right.<br/><br/>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suo enim quisque studio maxime ducitur. Scio enim esse quosdam, qui quavis lingua philosophari possint; Animum autem reliquis rebus ita perfecit, ut corpus; Quo modo autem optimum, si bonum praeterea nullum est? Dicet pro me ipsa virtus nec dubitabit isti vestro beato M. Sic enim censent, oportunitatis esse beate vivere.",
                ShowCaseContentPosition.LEFT));
        showCaseList.add(new ShowCaseDialog.TutorObject(
                null,
                null,
                "This is example without anchored View.<br/><br/>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suo enim quisque studio maxime ducitur. Scio enim esse quosdam, qui quavis lingua philosophari possint; Animum autem reliquis rebus ita perfecit, ut corpus; Quo modo autem optimum, si bonum praeterea nullum est? Dicet pro me ipsa virtus nec dubitabit isti vestro beato M. Sic enim censent, oportunitatis esse beate vivere."));

        int firstVisiblePosition = llm.findFirstVisibleItemPosition();
        View itemView = recyclerView.getChildAt(firstVisiblePosition);

        showCaseList.add(new ShowCaseDialog.TutorObject(
                itemView,
                null,
                "This is item in the recyclerView"));

        showCaseList.add(new ShowCaseDialog.TutorObject(
                itemView.findViewById(R.id.iv_icon),
                null,
                "This is icon"));

        showCaseList.add(new ShowCaseDialog.TutorObject(
                itemView.findViewById(R.id.iv_fav),
                null,
                "This is icon (2)",
                ShowCaseContentPosition.LEFT));

        showCaseDialog.show(this, showCaseList);
    }

}
