package course.labs.todomanager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ToDoListAdapter extends BaseAdapter {

	private final List<ToDoItem> mItems = new ArrayList<ToDoItem>();
	private final Context mContext;

	private static final String TAG = "Lab-UserInterface";

    private static final String DONE_TODO_COLOR = "#FFD0F3BC";
    private static final int DEADLINE_DATE_COLOR = Color.RED;
    private static final int NOT_DEADLINE_DATE_COLOR = Color.GRAY;

	public ToDoListAdapter(Context context) {

		mContext = context;

	}

	// Add a ToDoItem to the adapter
	// Notify observers that the data set has changed

	public void add(ToDoItem item) {

		mItems.add(item);
		notifyDataSetChanged();

	}

	// Clears the list adapter of all items.

	public void clear() {

		mItems.clear();
		notifyDataSetChanged();

	}

	// Returns the number of ToDoItems

	@Override
	public int getCount() {

		return mItems.size();

	}

	// Retrieve the number of ToDoItems

	@Override
	public Object getItem(int pos) {

		return mItems.get(pos);

	}

	// Get the ID for the ToDoItem
	// In this case it's just the position

	@Override
	public long getItemId(int pos) {

		return pos;

	}

	// Create a View for the ToDoItem at specified position
	// Remember to check whether convertView holds an already allocated View
	// before created a new View.
	// Consider using the ViewHolder pattern to make scrolling more efficient
	// See: http://developer.android.com/training/improving-layouts/smooth-scrolling.html
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		// TODO - Get the current ToDoItem
		//final ToDoItem toDoItem = null;
		final ToDoItem toDoItem = mItems.get(position);


		// TODO - Inflate the View for this ToDoItem
		// from todo_item.xml
		RelativeLayout itemLayout = null;

		LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		if (convertView == null) {
			itemLayout = (RelativeLayout) inflater.inflate(R.layout.todo_item, null);
		}
		else {
			itemLayout = (RelativeLayout) convertView;
		}

		// Fill in specific ToDoItem data
		// Remember that the data that goes in this View
		// corresponds to the user interface elements defined
		// in the layout file

		// TODO - Display Title in TextView

		final TextView titleView = (TextView) itemLayout.findViewById(R.id.titleView);
		titleView.setText(toDoItem.getTitle());

		// TODO - Set up Status CheckBox

		final CheckBox statusView = (CheckBox) itemLayout.findViewById(R.id.statusCheckBox);

		if (toDoItem.getStatus() == ToDoItem.Status.DONE) {
			statusView.setChecked(true);
            titleView.setPaintFlags(titleView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
		}
		else {
			statusView.setChecked(false);
            titleView.setPaintFlags(titleView.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));
		}

		// TODO - Must also set up an OnCheckedChangeListener,
		// which is called when the user toggles the status checkbox

        final RelativeLayout finalItemLayout = itemLayout;
        statusView.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {

                        final TextView dateView = (TextView) finalItemLayout.findViewById(R.id.dateView);

                        if (toDoItem.getStatus() == ToDoItem.Status.NOTDONE) {

                            toDoItem.setStatus(ToDoItem.Status.DONE);
                            statusView.setChecked(true);

                            titleView.setPaintFlags(titleView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

                            dateView.setTextColor(NOT_DEADLINE_DATE_COLOR);
                        }
                        else {
                            toDoItem.setStatus(ToDoItem.Status.NOTDONE);
                            statusView.setChecked(false);

                            titleView.setPaintFlags(titleView.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));

                            if ( (toDoItem.isDeadline()) && (toDoItem.getStatus() == ToDoItem.Status.NOTDONE)) {
                                dateView.setTextColor(DEADLINE_DATE_COLOR);
                            }
                        }
                        
					}
				});

		// TODO - Display Priority in a TextView

		final TextView priorityView = (TextView) itemLayout.findViewById(R.id.priorityView);
		priorityView.setText(toDoItem.getPriority().toString());


		// TODO - Display Time and Date.
		// Hint - use ToDoItem.FORMAT.format(toDoItem.getDate()) to get date and
		// time String

		final TextView dateView = (TextView) itemLayout.findViewById(R.id.dateView);
        dateView.setTextColor(NOT_DEADLINE_DATE_COLOR);
		dateView.setText(ToDoItem.FORMAT.format(toDoItem.getDate()));

        if ( (toDoItem.isDeadline()) && (toDoItem.getStatus() == ToDoItem.Status.NOTDONE)) {
            dateView.setTextColor(DEADLINE_DATE_COLOR);
        }

		// Return the View you just created
		return itemLayout;

	}
}
