package digi.coders.quizapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import digi.coders.quizapp.Models.QuizModel;

public class QuizeAdapter extends RecyclerView.Adapter<QuizeAdapter.myViewHolder> {
    Context context;
    List<QuizModel> quizModelList;

    public QuizeAdapter() {
    }

    public QuizeAdapter(Context context, List<QuizModel> quizModelList) {
        this.context = context;
        this.quizModelList = quizModelList;
    }


    @NonNull
    @Override
    public QuizeAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myViewHolder(LayoutInflater.from(context).inflate(R.layout.quiz_recycler,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull QuizeAdapter.myViewHolder holder, int position) {

        QuizModel quizModel = quizModelList.get(position);
        holder.question.setText(quizModel.getQuestion());


        holder.ques_1.setText(quizModel.getAnswer_a());
        holder.ques_2.setText(quizModel.getAnswer_b());
        holder.ques_3.setText(quizModel.getAnswer_c());
        holder.ques_4.setText(quizModel.getAnswer_d());
        holder.ques_5.setText(quizModel.getAnswer_e());
        holder.ques_6.setText(quizModel.getAnswer_f());


    }

    @Override
    public int getItemCount() {
        return quizModelList.size();
    }


    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView question,ques_1,ques_2,ques_3,ques_4,ques_5,ques_6;
        Button previousButton,NextButton;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            question = itemView.findViewById(R.id.question);
            ques_1 = itemView.findViewById(R.id.ques_1);
            ques_2 = itemView.findViewById(R.id.ques_2);
            ques_3 = itemView.findViewById(R.id.ques_3);
            ques_4 = itemView.findViewById(R.id.ques_4);
            ques_5 = itemView.findViewById(R.id.ques_5);
            ques_6 = itemView.findViewById(R.id.ques_6);

            previousButton = itemView.findViewById(R.id.previousButton);
            NextButton = itemView.findViewById(R.id.NextButton);

        }
    }
}
