<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Main extends CI_Controller {
	
	public function index()
	{
		$customerId = 2;
		$this->load->model("main_model");
<<<<<<< Updated upstream
		$transactionData = $this->main_model->getData();

		echo "<br><pre>Transaction type: ";print_r($transactionData);
	}
	public function transactions()
	{
		$this->load->model("main_model");
		$customers = $this->main_model->getCustomers();
		if ($customers != null) {
			foreach ($customers as $row => $customer) {
				echo "<br>Row id <b>{$row}</b> has the customer <b>{$customer->name}</b>, with the amount of <b>{$customer->amount} EUR</b> in account";
			}
		}else{
			echo "<br>No data in the customers table !";
		}
		
=======
		$getData = $this->main_model->getDashboardData($customerId);
		echo "<br> ".json_encode($getData)."<br> ";
		$this->load->view("dashboard_view",$getData);
>>>>>>> Stashed changes
	}
}

/* End of file main.php */
/* Location: ./application/controllers/main.php */