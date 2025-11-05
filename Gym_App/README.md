Gym Management System (Swing demo)

This is a small demo Gym Management System implemented in Java Swing. It provides a basic UI with:

- Role-based login (Admin, Trainer, Member). Default credentials:
  - admin / admin
  - trainer / trainer
  - member / member
- Dashboard with quick stats
- Member management: add, edit, delete, view members
- File-based persistence using Java serialization (saved to `gym_data.ser`)

How to run

From the project directory:

```bash
# compile
javac -d out *.java

# run
java -cp out Gym_App.GymApp
```

Notes & next steps

- This is a starting point. Recommendations for improving the app:
  - Add payments/invoicing persistence and UI
  - Add trainer scheduling and class bookings
  - Replace Java serialization with JSON (Gson/Jackson) for portability
  - Add backup/export, reports, and automated reminders
