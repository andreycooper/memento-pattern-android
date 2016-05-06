package by.cooper.memento;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import by.cooper.memento.databinding.ActivityMementoBinding;

public class MementoActivity extends AppCompatActivity {

    private static final String VIEW_MODEL = "view_model";
    private ViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Bundle is Caretaker and we can
        // restore ViewModel from the Bundle
        // or create a new instance of ViewModel if Bundle is not exist
        if (savedInstanceState != null) {
            mViewModel = savedInstanceState.getParcelable(VIEW_MODEL);
        } else {
            mViewModel = new ViewModel();
        }

        ActivityMementoBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_memento);
        // Set new or old ViewModel to binding
        binding.setViewModel(mViewModel);

        initToolbar(binding);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // As I said, Bundle is Caretaker and there we
        // put ViewModel into the Bundle
        outState.putParcelable(VIEW_MODEL, mViewModel);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initToolbar(ActivityMementoBinding binding) {
        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

}
