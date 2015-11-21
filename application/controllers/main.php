<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Main extends CI_Controller {
	
	public function index()
	{
		$customerId = 1;
		$this->load->model("main_model");
		$getData = $this->main_model->getDashboardData($customerId);
		echo "<br> ".var_dump($getData)."<br> ";
		$this->load->view("dashboard_view",$getData);
	}
}

/* End of file main.php */
/* Location: ./application/controllers/main.php */