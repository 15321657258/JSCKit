package jsc.exam.jsckit.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import jsc.exam.jsckit.adapter.ClassItemAdapter;
import jsc.exam.jsckit.entity.ClassItem;
import jsc.exam.jsckit.ui.component.AdvertisementViewActivity;
import jsc.exam.jsckit.ui.component.ArcHeaderViewActivity;
import jsc.exam.jsckit.ui.component.JSCBannerViewActivity;
import jsc.exam.jsckit.ui.component.JSCItemLayoutActivity;
import jsc.exam.jsckit.ui.component.JSCRoundCornerProgressBarActivity;
import jsc.exam.jsckit.ui.component.MonthViewActivity;
import jsc.exam.jsckit.ui.component.RadarViewActivity;
import jsc.exam.jsckit.ui.component.ReboundFrameLayoutActivity;
import jsc.exam.jsckit.ui.component.RefreshLayoutActivity;
import jsc.exam.jsckit.ui.component.RippleViewActivity;
import jsc.exam.jsckit.ui.component.SwipeRecyclerViewActivity;
import jsc.exam.jsckit.ui.component.TurntableViewActivity;
import jsc.exam.jsckit.ui.component.VScrollScreenLayoutActivity;
import jsc.exam.jsckit.ui.component.VerticalStepViewActivity;
import jsc.kit.swiperecyclerview.OnItemClickListener;

public class ComponentListActivity extends ABaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecyclerView recyclerView = new RecyclerView(this);
        recyclerView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setContentView(recyclerView);
        setTitle(getClass().getSimpleName().replace("Activity", ""));

        ClassItemAdapter adapter = new ClassItemAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener<ClassItem>() {
            @Override
            public void onItemClick(View view, ClassItem item) {
                startActivity(new Intent(view.getContext(), item.getCls()));
            }

            @Override
            public void onItemClick(View view, ClassItem item, int adapterPosition, int layoutPosition) {

            }
        });
        adapter.setItems(getClassItems());
    }

    private List<ClassItem> getClassItems() {
        List<ClassItem> classItems = new ArrayList<>();
        classItems.add(new ClassItem("ArcHeaderView", ArcHeaderViewActivity.class));
        classItems.add(new ClassItem("JSCBannerView", JSCBannerViewActivity.class));
        classItems.add(new ClassItem("MonthView", MonthViewActivity.class));
        classItems.add(new ClassItem("ReboundFrameLayout", ReboundFrameLayoutActivity.class));
        classItems.add(new ClassItem("VerticalStepView", VerticalStepViewActivity.class));
        classItems.add(new ClassItem("RefreshLayout", RefreshLayoutActivity.class));
        classItems.add(new ClassItem("SwipeRecyclerView", SwipeRecyclerViewActivity.class));
        classItems.add(new ClassItem("JSCRoundCornerProgressBar", JSCRoundCornerProgressBarActivity.class));
        classItems.add(new ClassItem("JSCItemLayout", JSCItemLayoutActivity.class));
        classItems.add(new ClassItem("VScrollScreenLayout", VScrollScreenLayoutActivity.class));
        classItems.add(new ClassItem("RadarView", RadarViewActivity.class));
        classItems.add(new ClassItem("TurntableView", TurntableViewActivity.class));
        classItems.add(new ClassItem("RippleView", RippleViewActivity.class));
        classItems.add(new ClassItem("AdvertisementView", AdvertisementViewActivity.class));
        return classItems;
    }
}
