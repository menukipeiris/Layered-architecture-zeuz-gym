package lk.ijse.gym.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.ijse.gym.bo.BOFactory;
import lk.ijse.gym.bo.custom.MemberBo;
import lk.ijse.gym.bo.custom.OrderBo;
import lk.ijse.gym.bo.custom.PlaceOrderBo;
import lk.ijse.gym.bo.custom.SupplimentBo;
import lk.ijse.gym.dao.Custom.MemberDao;
import lk.ijse.gym.dao.Custom.OrderDao;
import lk.ijse.gym.dao.Custom.PlaceOrderDao;
import lk.ijse.gym.dao.Custom.SupplimentDao;
import lk.ijse.gym.dao.DAOFactory;
import lk.ijse.gym.dto.MemberDto;
import lk.ijse.gym.dto.SupplimentDto;
import lk.ijse.gym.entity.Member;
import lk.ijse.gym.entity.PlaceOrder;
import lk.ijse.gym.entity.Suppliment;
import lk.ijse.gym.entity.tm.CartTm;
import lk.ijse.gym.entity.tm.MemberTm;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlaceOrderFormController {

    @FXML
    private JFXButton btnAddToCart;

    @FXML
    private ComboBox<String> cmbItemCode;

    @FXML
    private ComboBox<String> cmbMemberId;


    @FXML
    private TableColumn<?, ?> colAction;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private Label lblDescription;

    @FXML
    private Label lblMemberName;

    @FXML
    private Label lblNetTotal;

    @FXML
    private Label lblOrderDate;

    @FXML
    private Label lblOrderId;

    @FXML
    private Label lblQtyOnHand;

    @FXML
    private Label lblUnitPrice;

    @FXML
    private TableView<CartTm> tblOrderCart;

    @FXML
    private TextField txtQty;

    MemberBo memberBo= (MemberBo) BOFactory.getBoFactory().getBo(BOFactory.BOTypes.MEMBER);
    SupplimentBo supplimentBo= (SupplimentBo) BOFactory.getBoFactory().getBo(BOFactory.BOTypes.SUPPLIMENT);
    //OrderDao orderDao= (OrderDao) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.ORDER);
    OrderBo orderBo= (OrderBo) BOFactory.getBoFactory().getBo(BOFactory.BOTypes.ORDER);
    //PlaceOrderDao placeOrderDao= (PlaceOrderDao) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.PLACEORDER);
    PlaceOrderBo placeOrderBo= (PlaceOrderBo) BOFactory.getBoFactory().getBo(BOFactory.BOTypes.PLACEORDER);
    private ObservableList<CartTm> obList = FXCollections.observableArrayList();

    public void initialize() {
        setCellValueFactory();
        generateNextOrderId();
        setDate();
        loadMemberIds();
        loadItemCodes();
    }


    private void setCellValueFactory() {
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("tot"));
        colAction.setCellValueFactory(new PropertyValueFactory<>("btn"));
    }

    private void generateNextOrderId() {
        try {
            String orderId = orderBo.generateNextOrderId();
            lblOrderId.setText(orderId);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    private void loadMemberIds() {
        ObservableList<String> obList = FXCollections.observableArrayList();

        try {
            List<MemberTm> idList = memberBo.getAllMember();

            for (MemberTm dto : idList) {
                obList.add(dto.getMemberId());
            }

            cmbMemberId.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private void setDate() {
        lblOrderDate.setText(String.valueOf(LocalDate.now()));
    }


    private void loadItemCodes() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            List<SupplimentDto> supplimentDtos = supplimentBo.loadAllItem();

            for (SupplimentDto dto : supplimentDtos) {
                obList.add(dto.getCode());
            }
            cmbItemCode.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    void btnAddToCartOnAction(ActionEvent event) {
        String code = (String) cmbItemCode.getValue();
        String description = lblDescription.getText();
        int qty = Integer.parseInt(txtQty.getText());
        double unitPrice = Double.parseDouble(lblUnitPrice.getText());
        double tot = unitPrice * qty;
        Button btn = new Button("Remove");

        setRemoveBtnAction(btn);
        btn.setCursor(Cursor.HAND);


        if (!obList.isEmpty()) {
            for (int i = 0; i < tblOrderCart.getItems().size(); i++) {
                if (colItemCode.getCellData(i).equals(code)) {
                    int col_qty = (int) colQty.getCellData(i);
                    qty += col_qty;
                    tot = unitPrice * qty;

                    obList.get(i).setQty(qty);
                    obList.get(i).setTot(tot);

                    calculateTotal();
                    tblOrderCart.refresh();
                    return;
                }
            }
        }
        var cartTm = new CartTm(code, description, qty, unitPrice, tot, btn);

        obList.add(cartTm);

        tblOrderCart.setItems(obList);
        calculateTotal();
        txtQty.clear();

    }

    private void calculateTotal() {
        double total = 0;
        for (int i = 0; i < tblOrderCart.getItems().size(); i++) {
            total += (double) colTotal.getCellData(i);
        }
        lblNetTotal.setText(String.valueOf(total));

    }

    private void setRemoveBtnAction(Button btn) {
        btn.setOnAction((e) -> {
            ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

            Optional<ButtonType> type = new Alert(Alert.AlertType.INFORMATION, "Are you sure to remove?", yes, no).showAndWait();

            if (type.orElse(no) == yes) {
                int focusedIndex = tblOrderCart.getSelectionModel().getSelectedIndex();

                obList.remove(focusedIndex);
                tblOrderCart.refresh();
                calculateTotal();
                initialize();
            }

        });


    }

    @FXML
    void btnNewMemberOnAction(ActionEvent event) throws IOException {
        Parent anchorPane = FXMLLoader.load(getClass().getResource("/view/member_form.fxml"));
        Scene scene = new Scene(anchorPane);

        Stage stage = new Stage();
        stage.setTitle("Member Manage");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {
        String orderId = lblOrderId.getText();
        LocalDate date = LocalDate.parse(lblOrderDate.getText());
        String memberId = (String) cmbMemberId.getValue();

        List<CartTm> cartTmList = new ArrayList<>();
        for (int i = 0; i < tblOrderCart.getItems().size(); i++) {
            CartTm cartTm = obList.get(i);

            cartTmList.add(cartTm);
        }

        System.out.println("Place order form controller: " + cartTmList);
        var placeOrder = new PlaceOrder(orderId, date, memberId, cartTmList);
        try {
            boolean isSuccess = placeOrderBo.placeOrder(placeOrder);
            if (isSuccess) {
                new Alert(Alert.AlertType.CONFIRMATION, "Order Success!").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void cmbItemOnAction(ActionEvent event) {
        String code = cmbItemCode.getValue();

        txtQty.requestFocus();
        try {
            SupplimentDto suppliment = supplimentBo.searchItems(code);
            lblDescription.setText(suppliment.getDescription());
            lblUnitPrice.setText(String.valueOf(suppliment.getUnitPrice()));
            lblQtyOnHand.setText(String.valueOf(suppliment.getQtyOnHand()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void cmbMemberOnAction(ActionEvent event) {
        String id = cmbMemberId.getValue();
        try {
            MemberDto memberDto = memberBo.searchMember(id);
            lblMemberName.setText(memberDto.getName());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    void txtQtyOnAction(ActionEvent event) {
        btnAddToCartOnAction(event);
    }

    public void btnBackOnAction(ActionEvent event) throws IOException {
        Parent anchorPane = FXMLLoader.load(getClass().getResource("/view/Dashboard_form.fxml"));
        Scene scene = new Scene(anchorPane);

        Stage stage = new Stage();
        stage.setTitle("Dashboard");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
