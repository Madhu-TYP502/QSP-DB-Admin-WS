package com.tyss.dashboard.admin.api.client;

import java.util.List;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.tyss.dashboard.admin.data.entities.BatchEntity;
import com.tyss.dashboard.admin.model.BatchDto;

import feign.FeignException;

@FeignClient(name = "batch-mng-ws", fallbackFactory = BatchConsumerFallbackFactory.class)
public interface BatchConsumer {

	@GetMapping("batchmng/get/status")
	public ResponseEntity<String> status();

	@PostMapping("batchmng/create/batch")
	public ResponseEntity<String> createBatch(@RequestBody BatchDto batchDto);

	@GetMapping("batchmng/get/batch")
	public ResponseEntity<BatchEntity> viewBatch(@RequestParam String batchCode);

	@GetMapping("batchmng/get/trainer/batch")
	public ResponseEntity<List<BatchEntity>> viewBatchByTrainer(@RequestParam String trainerID);

	@PostMapping("batchmng/update/batch")
	public ResponseEntity<String> updateBatch(@RequestBody BatchEntity batch);

	@DeleteMapping("batchmng/delete/batch")
	public ResponseEntity<String> deleteBatch(@RequestBody BatchEntity batch);
}

@Component
class BatchConsumerFallbackFactory implements FallbackFactory<BatchConsumer> {

	@Override
	public BatchConsumer create(Throwable cause) {
		return new BatchConsumerFallback(cause);
	}

}

class BatchConsumerFallback implements BatchConsumer {
	private Throwable cause;

	public BatchConsumerFallback(Throwable cause) {
		this.cause = cause;
	}

	@Override
	public ResponseEntity<String> status() {
		return null;
	}

	@Override
	public ResponseEntity<String> createBatch(BatchDto batchDto) {

		return ResponseEntity.status(((FeignException) cause).status())
				.body(formatErrorMessage(cause.getLocalizedMessage()));
	}

	@Override
	public ResponseEntity<BatchEntity> viewBatch(String batchCode) {
		return ResponseEntity.status(((FeignException) cause).status()).body(null);

	}

	@Override
	public ResponseEntity<List<BatchEntity>> viewBatchByTrainer(String trainerID) {
		return ResponseEntity.status(((FeignException) cause).status()).body(null);
	}

	@Override
	public ResponseEntity<String> updateBatch(BatchEntity batch) {
		return ResponseEntity.status(((FeignException) cause).status())
				.body(formatErrorMessage(cause.getLocalizedMessage()));

	}

	@Override
	public ResponseEntity<String> deleteBatch(BatchEntity batch) {
		return ResponseEntity.status(((FeignException) cause).status())
				.body(formatErrorMessage(cause.getLocalizedMessage()));

	}

	private String formatErrorMessage(String message) {
		return message.substring(message.indexOf("$") + 1, message.length() - 1);
	}

}