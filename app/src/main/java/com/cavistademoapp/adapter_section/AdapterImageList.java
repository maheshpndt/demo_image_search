package com.cavistademoapp.adapter_section;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.cavistademoapp.R;
import com.cavistademoapp.interface_section.ClickListener;
import com.cavistademoapp.request_response_section.Datum;
import com.cavistademoapp.request_response_section.Image;
import com.facebook.drawee.view.SimpleDraweeView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class AdapterImageList extends RecyclerView.Adapter<AdapterImageList.ViewHolder> {

    private final Context mContext;
    private List<Image> mListOfImages = new ArrayList<>();
    private ClickListener mListener;

    public AdapterImageList(Context context, ClickListener listener) {
        this.mContext = context;
        this.mListener = listener;
    }

    public void updateData(List<Datum> results) {

        for (Datum data : results) {
//            this.mListOfBooks.add(new Datum("data.getAuthors()", "data.getBookshelves()", "", "data.getFormats()", "data.getId()", "data.getLanguages()", "data.getMediaType()", "data.getSubjects()", "data.getTitle()"));
        }

        notifyDataSetChanged();
    }

    public void addData(List<Image> results) {
        this.mListOfImages.clear();
        this.mListOfImages = results;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_images, parent, false);
        return new ViewHolder(mView);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.mTextTitle.setText(mListOfImages.get(position).getAdUrl());
        try {
            holder.mTextAuthor.setText(mListOfImages.get(position).getAdUrl());
        } catch (IndexOutOfBoundsException e) {
        }

        loadImage(holder, String.valueOf(mListOfImages.get(position).getLink()));

    }

    private void loadImage(ViewHolder holder, String mImageJpeg) {
        Uri uri = Uri.parse(mImageJpeg);
        holder.mImageCategory.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return mListOfImages.size();
    }

    /*
     * Get all items view id's to access view element
     * */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private final WeakReference<ClickListener> listenerRef;
        private final TextView mTextTitle;
        private final TextView mTextAuthor;
        private final SimpleDraweeView mImageCategory;
        private final ConstraintLayout mLayoutCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            listenerRef = new WeakReference<>(mListener);
            mTextTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
            mTextAuthor = (TextView) itemView.findViewById(R.id.textViewAuthor);
            mImageCategory = (SimpleDraweeView) itemView.findViewById(R.id.imageViewCategory);
            mLayoutCard = (ConstraintLayout) itemView.findViewById(R.id.layoutCard);

            mLayoutCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listenerRef.get().onPositionClicked(getAdapterPosition());
                }
            });
        }
    }
}
