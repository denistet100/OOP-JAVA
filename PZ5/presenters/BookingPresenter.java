package PZ5.presenters;

import PZ5.models.Table;
import PZ5.models.TableModel;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private final Model model;
    private final View view;
    private Collection<Table> tables;

    public BookingPresenter(Model model, View view){
        this.model = model;
        this.view = view;
        this.view.setObserver(this);
    }

    /**
     * Загрузить список всех столиков
     */
    public void loadTables(){
        if (tables == null){
            tables = model.loadTables();
        }
    }

    /**
     * Отобразить список столиков
     */
    public void updateView(){
        view.showTables(tables);
    }

    /**
     * Отобразить результат бронирования столика
     * @param reservationNo номер брони
     */
    private void updateReservationStatusView(int reservationNo){
        view.showReservationStatus(reservationNo);
    }

    /**
     * Отобразить результат бронирования столика
     * @param reservationNo номер брони
     */
    private void updateChangeReservationStatusView(int reservationNo){
        view.showChangeReservationStatus(reservationNo);
    }

    /**
     * Получили уведомление о попытке бронирования столика
     * @param orderDate дата бронирования
     * @param tableNo номер столика
     * @param name имя клиента
     */
    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        int reservationNo = model.reservationTable(orderDate, tableNo, name);
        updateReservationStatusView(reservationNo);
    }

    /**
     * Получили уведомление о попытке смены бронирования столика
     * @param oldReservation старая дата бронирования
     * @param reservationDate новая дата бронирования
     * @param tableNo номер столика
     * @param name имя клиента
     */
    @Override
    public void onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        int reservationNo = model.reservationTable(reservationDate, tableNo, name);
        updateChangeReservationStatusView(oldReservation);
        updateReservationStatusView(reservationNo);
    }
}
