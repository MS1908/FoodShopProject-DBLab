// re-list all constants of Orders cla2ss in backend
const CANCELLED = -1;
const SUBMITTED = 0;
const CONFIRMED = 1;
const SHIPPING = 2;
const SHIPPED = 3;

const PAID = true;
const UNPAID = false;

function getProcessStatus(status) {
    switch(status) {
        case CANCELLED:
            return "Cancelled";
        case SUBMITTED:
            return "Submitted";
        case CONFIRMED:
            return "Confirmed";
        case SHIPPED:
            return "Shipped";
        case SHIPPING:
            return "Shipping";
        default:
            return "Error";
    }
}

function getPaymentStatus(status) {
    switch(status) {
        case PAID:
            return "Paid";
        case UNPAID:
            return "UnPaid";
        default:
            return "Error";
    }
}