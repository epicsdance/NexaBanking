package com.nexa.banking;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private final int navy = Color.rgb(13, 27, 48);
    private final int teal = Color.rgb(0, 135, 128);
    private final int gold = Color.rgb(211, 170, 79);

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(navy);
        getWindow().setNavigationBarColor(navy);

        ScrollView scroll = new ScrollView(this);
        scroll.setBackgroundColor(Color.rgb(246, 248, 251));
        LinearLayout page = new LinearLayout(this);
        page.setOrientation(LinearLayout.VERTICAL);
        page.setPadding(dp(20), dp(22), dp(20), dp(28));
        scroll.addView(page);

        LinearLayout header = new LinearLayout(this);
        header.setOrientation(LinearLayout.VERTICAL);
        header.setPadding(dp(20), dp(22), dp(20), dp(22));
        header.setBackground(round(navy, 22));
        TextView mark = text("N", 28, gold, true);
        mark.setGravity(Gravity.CENTER);
        mark.setBackground(round(Color.rgb(31, 53, 76), 50));
        header.addView(mark, new LinearLayout.LayoutParams(dp(54), dp(54)));
        TextView title = text("NEXA BANKING", 23, Color.WHITE, true);
        title.setPadding(0, dp(14), 0, dp(3));
        header.addView(title);
        TextView subtitle = text("DIGITAL SERVICES", 12, gold, true);
        header.addView(subtitle);
        TextView note = text("Your service dashboard", 15, Color.rgb(218, 228, 238), false);
        note.setPadding(0, dp(15), 0, 0);
        header.addView(note);
        page.addView(header);

        TextView welcome = text("How can we help you today?", 20, navy, true);
        welcome.setPadding(0, dp(24), 0, dp(12));
        page.addView(welcome);

        addCard(page, "Account Services", "Request account-related support", "Open service request");
        addCard(page, "Balance Enquiry", "Continue through your authorised banking partner", "Start enquiry");
        addCard(page, "Mini Statement", "Request a statement using an approved provider", "Request statement");
        addCard(page, "AEPS / Aadhaar Banking", "Available only through an authorised provider", "View service info");
        addCard(page, "ATM & Branch Locator", "Find nearby banking locations", "Find locations");
        addCard(page, "Customer Care", "Get help with a service or complaint", "Contact support");

        TextView disclaimer = text(
            "DEMO APP • No real banking transactions are performed. Do not enter PINs, passwords, card details, or OTPs here. Live services require an authorised provider, secure backend, and required approvals.",
            12, Color.rgb(87, 99, 114), false);
        disclaimer.setPadding(dp(4), dp(18), dp(4), dp(8));
        page.addView(disclaimer);
        setContentView(scroll);
    }

    private void addCard(LinearLayout page, String heading, String desc, String buttonLabel) {
        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(dp(16), dp(15), dp(16), dp(15));
        card.setBackground(round(Color.WHITE, 18));
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-1, -2);
        lp.setMargins(0, 0, 0, dp(12));
        page.addView(card, lp);

        TextView h = text(heading, 17, navy, true);
        card.addView(h);
        TextView d = text(desc, 13, Color.rgb(91, 103, 118), false);
        d.setPadding(0, dp(6), 0, dp(12));
        card.addView(d);
        TextView button = text(buttonLabel + "  ›", 14, Color.WHITE, true);
        button.setGravity(Gravity.CENTER);
        button.setPadding(dp(14), dp(11), dp(14), dp(11));
        button.setBackground(round(teal, 12));
        button.setOnClickListener(v ->
            Toast.makeText(this, "Demo only. Connect an authorised provider to enable this service.", Toast.LENGTH_LONG).show());
        card.addView(button);
    }

    private TextView text(String s, int size, int color, boolean bold) {
        TextView t = new TextView(this);
        t.setText(s);
        t.setTextSize(size);
        t.setTextColor(color);
        if (bold) t.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        return t;
    }

    private GradientDrawable round(int color, int radius) {
        GradientDrawable d = new GradientDrawable();
        d.setColor(color);
        d.setCornerRadius(dp(radius));
        return d;
    }

    private int dp(int n) { return (int)(n * getResources().getDisplayMetrics().density + 0.5f); }
}
