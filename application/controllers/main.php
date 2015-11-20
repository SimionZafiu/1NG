<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Main extends CI_Controller {
	
	public function index()
	{
		
		$this->load->view("dashboard_view");
	}

	public function test()
	{
		$this->load->model("main_model");
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
		
	}
}

/* End of file main.php */
/* Location: ./application/controllers/main.php */