package by.cooper.memento;


import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;

import by.cooper.memento.helpers.Objects;

// ViewModel is Originator
public class ViewModel extends BaseObservable implements Parcelable {

    // It's a State
    private String name;

    //region Constructors
    public ViewModel() {

    }

    protected ViewModel(Parcel in) {
        // Parcel is Memento, we restore state from it there
        this.name = in.readString();
    }
    //endregion


    @Bindable
    public String getGreetings() {
        return "Greetings, " + name + "!";
    }

    public void onNameChanged(Editable str) {
        String newName = str.toString();
        if (!Objects.equals(name, newName)) {
            name = newName;
            notifyPropertyChanged(by.cooper.memento.BR.greetings);
            notifyPropertyChanged(by.cooper.memento.BR.nameExist);
        }
    }

    @Bindable
    public boolean isNameExist() {
        return !TextUtils.isEmpty(name);
    }

    //region Parcelable implementation
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // Save state from Originator to Memento here
        dest.writeString(this.name);
    }

    public static final Parcelable.Creator<ViewModel> CREATOR = new Parcelable.Creator<ViewModel>() {
        @Override
        public ViewModel createFromParcel(Parcel source) {
            return new ViewModel(source);
        }

        @Override
        public ViewModel[] newArray(int size) {
            return new ViewModel[size];
        }
    };
    //endregion
}
