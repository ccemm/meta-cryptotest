#include <QApplication>
#include <QLabel>
#include <QPushButton>
#include <QVBoxLayout>
#include <QWidget>

int main(int argc, char *argv[])
{
    QApplication app(argc, argv);

    QWidget window;
    auto *label  = new QLabel("ILI9341 + Qt on BBB");
    auto *button = new QPushButton("Count: 0");
    label->setAlignment(Qt::AlignCenter);

    int count = 0;
    QObject::connect(button, &QPushButton::clicked, [&]() {
        button->setText(QString("Count: %1").arg(++count));
    });

    auto *layout = new QVBoxLayout(&window);
    layout->addWidget(label);
    layout->addWidget(button);

    window.showFullScreen();
    return app.exec();
}
